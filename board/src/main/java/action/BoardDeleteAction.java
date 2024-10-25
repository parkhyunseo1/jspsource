package action;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import lombok.AllArgsConstructor;
import service.BoardService;
import service.BoardServiceImpl;


@AllArgsConstructor
public class BoardDeleteAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	
		BoardDTO deleteDto = new BoardDTO();
		deleteDto.setBno(Integer.parseInt(request.getParameter("bno")));
		deleteDto.setPassword(request.getParameter("password"));
		
		
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
				
			
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"utf-8");
				
		
		BoardService service = new BoardServiceImpl();
		boolean deleteFlag = service.delete(deleteDto);
		
		if (deleteFlag) {
			// 성공 시 bno 보내기(상세조회 시 필요)
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		} else {
			path="/modify.do?bno="+deleteDto.getBno()+"&page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		}
				
		return new ActionForward(path, true);
	}

}
