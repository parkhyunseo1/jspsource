<%@page import="dao.MemberDao"%>
<%@page import="dto.ChangeDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
//password.jsp 에서 넘긴 값 가져와서 ChangeDTO에 담기
	ChangeDTO changeDTO = new ChangeDTO();
  changeDTO.setUserid(request.getParameter("userid"));
  changeDTO.setCurentPassword(request.getParameter("curent_password"));
  changeDTO.setChangePassword(request.getParameter("change_password"));
  
  
  MemberDao dao = new MemberDao();
  int updateRow = dao.update(changeDTO);
  
  // updateRow == 1 일때 세션 제거 / login.jsp로 이동
	if(updateRow == 1){
		session.invalidate();
		response.sendRedirect("login.jsp");
	} else{
   // updateRow == 0 일때 password.jsp로 이동
  response.sendRedirect("password.jsp");
	}
%>
	
	
    