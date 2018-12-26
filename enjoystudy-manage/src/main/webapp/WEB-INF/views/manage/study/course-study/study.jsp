<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
    <%@ include file="/WEB-INF/views/common/meta.jsp" %>
    <%@ include file="/WEB-INF/views/common/javascript.jsp" %>
    <script type="text/javascript" src="<c:url value='/static/js/common/ckplayer6.8/ckplayer/ckplayer.js'/>"></script>
    <title>课程视频学习</title>
</head>
<body>
<article id="ckplayer" class="page-container"></article>
<script type="text/javascript">
    var flashvars = {
        f: '<c:url value="${video.filePath}"/>',
        c: 0,
        b:1,
        <c:if test="${not empty video.image }">i:'<c:url value="${video.image}"/>'</c:if>
    };
    var params = {
        bgcolor: '#FFF',
        allowFullScreen: true,
        allowScriptAccess: 'always',
        wmode: 'transparent'
    };
    CKobject.embedSWF('<c:url value="/static/js/common/ckplayer6.8/ckplayer/ckplayer.swf"/>', 'ckplayer', 'ckplayer_a1', '600', '400', flashvars, params);
    /* CKobject.embedSWF(播放器路径,容器id,播放器id/name,播放器宽,播放器高,flashvars的值,其它定义也可省略); */

    var video = ['<c:url value="${video.filePath}"/>->video/mp4'];
    var support = ['iPad', 'iPhone', 'ios', 'android+false', 'msie10+false'];
    CKobject.embedHTML5('ckplayer', 'ckplayer_a1', 600, 400, video, flashvars, support);
</script>
</body>
</html>