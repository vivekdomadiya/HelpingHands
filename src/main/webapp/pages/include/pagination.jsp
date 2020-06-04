<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${totalPageNo > 1}">

	<c:url var="currentUrl" value="">
	<c:forEach items="${param}" var="entry">
		<c:if test="${entry.key != 'page'}">
			<c:param name="${entry.key}" value="${entry.value}" />
		</c:if>
	</c:forEach>
	<c:param name="page" value="" />
	</c:url>

	<hr>
	<nav aria-label="Page navigation">
		<ul class="pagination">
		<c:if test="${pageNo != 1}">
			<li class="page-item disable"><a class="page-link" href="${currentUrl}${pageNo - 1}" aria-label="Previous">&laquo;</a></li>
		</c:if>
		<c:forEach var = "i" begin = "1" end = "${totalPageNo}">
			<c:choose>
				<c:when test="${pageNo == i}">
					<li class="page-item active"><a class="page-link" href="${currentUrl}${i}">${i}</a></li>
				</c:when>
				<c:otherwise>
					<li class="page-item"><a class="page-link" href="${currentUrl}${i}">${i}</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageNo != totalPageNo}">
			<li class="page-item"><a class="page-link" href="${currentUrl}${pageNo + 1}" aria-label="Next">&raquo;</a></li>
		</c:if>
		</ul>
	</nav>
</c:if>