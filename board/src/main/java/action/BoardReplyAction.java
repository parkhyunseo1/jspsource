package action;

import java.io.File;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;


@AllArgsConstructor
public class BoardReplyAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDTO replyDto = new BoardDTO();
		
		replyDto.setName(request.getParameter("name"));
		replyDto.setPassword(request.getParameter("password"));
		replyDto.setTitle(request.getParameter("title"));
		replyDto.setContent(request.getParameter("content"));
		
		
		// hidden  부모 정보 
		replyDto.setRe_lev(Integer.parseInt(request.getParameter("re_lev")));
		replyDto.setRe_ref(Integer.parseInt(request.getParameter("re_ref")));
		replyDto.setRe_seq(Integer.parseInt(request.getParameter("re_seq")));
		replyDto.setBno(Integer.parseInt(request.getParameter("bno")));
	
		
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
				
			
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"utf-8");
		
		BoardService service = new BoardServiceImpl();
		boolean replyFlag = service.reply(replyDto);
		
		if (replyFlag) {
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		} else {
			path = "/replyView.do?bno="+replyDto.getBno()+"&page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword	;
		}
				
		return new ActionForward(path, true);
	}
	
	
}
