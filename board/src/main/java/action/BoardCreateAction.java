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
public class BoardCreateAction implements Action {
	
	private String path;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BoardDTO insertDto = new BoardDTO();
		
		insertDto.setName(request.getParameter("name"));
		insertDto.setPassword(request.getParameter("password"));
		insertDto.setTitle(request.getParameter("title"));
		insertDto.setContent(request.getParameter("content"));
		
		int page = Integer.parseInt(request.getParameter("page"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		// 검색 추가
		String criteria = request.getParameter("criteria");
		String keyword = URLEncoder.encode(request.getParameter("keyword"),"utf-8");
		// 첨부파일 가져오기(서블릿 기능 이용)
		Part part = request.getPart("attach");
		String fileName = getFileName(part);
		
		System.out.println(fileName);
		
		// 서버로 전송된 파일 저장(서버 특정 폴더)
		String saveDir = "c:\\upload";
		if(!fileName.isEmpty()) {
			// 고유의키값_파일명
			UUID uuid = UUID.randomUUID();
			
			// File.separator: \ or / (운영체제에 맞게 넣어줌)
			// c:\\upload\\1.jpg
			File f = new File(saveDir + File.separator + uuid + "_" + fileName);
			part.write(f.toString());
			insertDto.setAttach(f.getName());
		}
		
		
		BoardService service = new BoardServiceImpl();
		boolean insertflag = service.create(insertDto);
		
		if (insertflag) {
			// 성공 시 bno 보내기(상세조회 시 필요)
			path += "?page="+page+"&amount="+amount+"&criteria="+criteria+"&keyword="+keyword;
		} else {
			path ="/board/create.jsp";
		}
				
		return new ActionForward(path, true);
	}
	private String getFileName(Part part) {
		// content-disposition : attachment; filename-file.jpg
		String header = part.getHeader("content-disposition");
		String[] arr = header.split(";");
		for(int i = 0; i<arr.length; i++) {
			String temp = arr[i];
			if(temp.trim().startsWith("filename")) {
				return temp.substring(temp.indexOf("=")+2, temp.length()-1);
			}
		}
		return "";
	}
	
}
