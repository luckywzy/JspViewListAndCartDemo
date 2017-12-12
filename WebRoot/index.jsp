<%@page import="entity.Items"%>
<%@ page language="java" import="java.util.*, java.text.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="dao.ItemsDao" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>商品展示</title>
</head>
<body>
	<h1>商品展示</h1>
	<hr>
	
	<center>
		<table>
			<tr>
				<td>
					<!-- 商品循环开始 -->
					<%
						ItemsDao itemsDao = new ItemsDao();
						ArrayList<Items> list = itemsDao.getAllItems();
						if(list != null && list.size() > 0)
						{
							for(int i=0; i<list.size(); i++)
							{
								Items item = list.get(i);
					%>
						<dl>
							<dt>
								<a href="details.jsp?id=<%=item.getId() %>"><img src="images/<%=item.getPicture()%>"></a>
							</dt>
							<dd class="dd_name"><%=item.getName() %></dd>
							<dd>产地：<%=item.getCity() %></dd>
							<dd>价格：<%=item.getPrice() %></dd>
						</dl>
					<!-- 商品循环结束 -->	
						<%
							}	
						}
						%>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>