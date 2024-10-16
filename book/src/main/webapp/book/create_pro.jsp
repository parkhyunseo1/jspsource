<%@page import="dao.BookDAO"%>
<%@page import="dto.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");	

	//1. 가져올 값(== 넘어오는 값)이 있는지 확인
	// 시작하느 페이지에서 form 이 존재
	// a 태그 ? 다음에 넘어오는지
		BookDTO insertDto = new BookDTO();
	//pk, 수정할 컬럼 가져오기
	insertDto.setCode(Integer.parseInt(request.getParameter("code")));
	insertDto.setPrice(Integer.parseInt(request.getParameter("price")));
	insertDto.setTitle(request.getParameter("title"));
	insertDto.setWriter(request.getParameter("writer"));
		insertDto.setDescription(request.getParameter("description"));
	
			
		
	//2. DB작업
	
	BookDAO dao =new BookDAO();
	int isertRow =dao.insert(insertDto);
	
		
	//4. 페이지 이동(client 볼 페이지)
		if(isertRow == 0){
		
			response.sendRedirect("create.jsp");
	}else{
   // updateRow == 0 일때 password.jsp로 이동
		   response.sendRedirect("list_pro.jsp");
  }
%>