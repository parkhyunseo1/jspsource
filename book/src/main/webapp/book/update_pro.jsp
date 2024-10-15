<%@page import="dto.BookDTO"%>
<%@page import="dao.BookDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");	

	//1. 가져올 값(== 넘어오는 값)이 있는지 확인
	// 시작하는 페이지에서 form 이 존재
	// a 태그 ? 다음에 넘어오는지
	BookDTO updateDto = new BookDTO();
	//pk, 수정할 컬럼 가져오기
	updateDto.setCode(Integer.parseInt(request.getParameter("code")));
	updateDto.setPrice(Integer.parseInt(request.getParameter("price")));
	updateDto.setDescription(request.getParameter("description"));
			
	//2. db 작업
	BookDAO dao = new BookDAO();
	int updateRow = dao.update(updateDto);
	
	
	//3. 결과값 공유(수정,삭제,삽입 x)
	//결과값 공유할거 x 일때 sendRedirect
		if(updateRow == 0){
		
			response.sendRedirect("modify_pro.jsp?=code"+updateDto.getCode());
	}else{
   // updateRow == 0 일때 password.jsp로 이동
		   response.sendRedirect("list_pro.jsp");
  }
	
	//4. 페이지 이동(client 볼 페이지)
	// 0이 리턴되면 modify_pro.jsp
	// 1이 리턴되면 list_pro.jsp
	
	

%>