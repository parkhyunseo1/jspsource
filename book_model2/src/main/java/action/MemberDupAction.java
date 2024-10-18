package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.BookDTO;
import dto.MemberDTO;
import lombok.AllArgsConstructor;
import service.BookService;
import service.BookServiceImpl;
import service.MemberSeriveImpl;
import service.MemberService;

@AllArgsConstructor
public class MemberDupAction implements Action {

	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 1.
		String userid = request.getParameter("userid");
		
		// 2. service 호출
		MemberService service = new MemberSeriveImpl();
		boolean dupFlag = service.duplicateId(userid);

		if (dupFlag) {
			request.setAttribute("dup", "true");
		} else {
			request.setAttribute("dup", "false");
		
		}

		return new ActionForward(path, false);

	}
}
