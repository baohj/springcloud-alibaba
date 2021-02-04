/*
package com.tjgx.common.product.es;

import com.aliyun.openservices.shade.com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Sequence;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bosscloud.commercial.common.enums.CommercialOpportunityStatusEnum;
import com.bosscloud.commercial.common.util.CommonUtil;
import com.bosscloud.commercial.common.util.HttpUtils;
import com.bosscloud.commercial.common.util.LocalDateTimeUtils;
import com.bosscloud.commercial.dto.req.AddCountReq;
import com.bosscloud.commercial.dto.req.CmsSelectPageReq;
import com.bosscloud.commercial.dto.req.CommercialOpportunitySaveReq;
import com.bosscloud.commercial.dto.req.CommercialPageReq;
import com.bosscloud.commercial.dto.resp.*;
import com.bosscloud.commercial.model.CommercialOpportunity;
import com.bosscloud.commercial.service.CommercialOpportunityService;
import com.bosscloud.commercial.service.fegin.InteractFegin;
import com.bosscloud.commercial.service.fegin.UserFegin;
import com.bosscloud.servicegeneral.service.RequestHeaderService;
import com.bosscloud.serviceresult.core.Result;
import com.bosscloud.user.common.enums.UserAuthStatusEnum;
import com.bosscloud.user.dto.common.UserThirdInfoDto;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

*/
/**
 * <p>
 * 商机内容服务类
 * </p>
 *
 * @author mybatisplusAutogenerator
 * @since 2020-06-12
 *//*

@Service
@Slf4j
public class CommercialOpportunityManager {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    */
/**
     * 从es获取商机
     *
     * @param uId       当前用户id
     * @param content   搜索内容
     * @param pageIndex 页码
     * @param pageSize  页条数
     * @return List
     * @throws IOException 异常
     *//*

    private List<CommercialOpportunity> findCommercialFromEs(Long uId, String content, long pageIndex, long pageSize) throws IOException {
        // 条件,查询没有被删除，并且通过状态的商机
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        if (!StringUtils.isEmpty(content)) {
            boolQueryBuilder.must(QueryBuilders.matchQuery("content", content));
        }
        BoolQueryBuilder boolQueryBuilderV2 = QueryBuilders.boolQuery();
        boolQueryBuilderV2.should(QueryBuilders.termQuery("auditStatus", 2));

        BoolQueryBuilder mustQuery = QueryBuilders.boolQuery();
        if (Objects.nonNull(uId)) {
            mustQuery.must(QueryBuilders.termQuery("userId", uId));
        }
        mustQuery.must(QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery("auditStatus", 2)));
        boolQueryBuilderV2.should(mustQuery);
        boolQueryBuilder.must(boolQueryBuilderV2);
        // 高亮设置
        HighlightBuilder highlighterBuilder = new HighlightBuilder();
        highlighterBuilder.preTags("<i>").postTags("</i>").field("content");
        // 排序
        long index = pageIndex;
        long size = pageSize;
        index = index == 0 ? 1 : index;
        FieldSortBuilder createTimeSort = SortBuilders.fieldSort("createDate").order(SortOrder.DESC);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(boolQueryBuilder).highlighter(highlighterBuilder)
                .sort(createTimeSort).from((int) ((index - 1) * size)).size((int)size);
        log.info("查询商机DSL如下：{}", searchSourceBuilder.toString());
        SearchResponse result = restHighLevelClient.search(new SearchRequest("commercial_opportunity").source(searchSourceBuilder), RequestOptions.DEFAULT);
        SearchHit[] searchHits = result.getHits().getHits();
        log.info("从es获取商机数据:{}", JSON.toJSONString(searchHits));
        */
/**
         * 转换对象
         *//*

        List<CommercialOpportunity> list = Arrays.stream(searchHits).map(v -> {
            Map<String, Object> sourceAsMap = v.getSourceAsMap();
            Set<String> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            if (content != null && content.length() > 0) {
                //使用jsoup解析高亮关键词
                HighlightField li = v.getHighlightFields().get("content");
                Text[] fragments = li.getFragments();
                Arrays.stream(fragments).forEach(o -> {
                    String str = o.string();
                    int len = str.indexOf("<i>");
                    if (len > 20) {
                        str = str.substring(len - 20);
                    }
                    sb.append(str.replace("<i>", "").replace("</i>", ""));
                    Document doc = Jsoup.parse("<html>" + o.string() + "</html>");
                    Elements elements = doc.getElementsByTag("i");
                    List<String> highlights = elements.stream().map(m -> m.text()).collect(toList());
                    set.addAll(highlights);
                });
            } else {
                sb.append((String) sourceAsMap.get("content"));
            }
            CommercialOpportunity opportunity = new CommercialOpportunity();
            opportunity.setAspectRatio((String) sourceAsMap.get("aspectRatio"));
            opportunity.setId(v.getId());
            Object userId = sourceAsMap.get("userId");
            opportunity.setUserId(Objects.nonNull(userId) ? Long.parseLong(userId.toString()) : null);
            opportunity.setUserName((String) sourceAsMap.get("userName"));
            if (sourceAsMap.get("startTimeForTop") != null) {
                LocalDateTime startTimeForTop = LocalDateTimeUtils.stringToLocalDateTime(((String) sourceAsMap.get("startTimeForTop"))
                        .replace("T", " "));
                opportunity.setStartTimeForTop(startTimeForTop);
            }
            if (sourceAsMap.get("endTimeForTop") != null) {
                LocalDateTime endTimeForTop = LocalDateTimeUtils.stringToLocalDateTime(((String) sourceAsMap.get("endTimeForTop")).replace("T", " "));
                opportunity.setEndTimeForTop(endTimeForTop);
            }
            opportunity.setCommercialTags((String) sourceAsMap.get("commercialTags"));
            opportunity.setMediaUrls((String) sourceAsMap.get("mediaUrls"));
            Object createDate = sourceAsMap.get("createDate");
            if (createDate != null) {
                String createDateStr = (String) createDate;
                opportunity.setCreateDate(LocalDateTimeUtils.stringToLocalDateTime(createDateStr.replace("T", " ")));
            }
            opportunity.setHighlights(set);
            opportunity.setContent(sb.toString());
            return opportunity;
        }).collect(toList());
        return list;
    }

}
*/
