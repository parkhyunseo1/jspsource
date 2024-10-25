package service;

import java.util.List;

import dto.BoardDTO;
import dto.SearchDTO;

// CRUD  호출

public interface BoardService {
	List<BoardDTO> listAll(SearchDTO searchDTO);
	BoardDTO getRow(int bno);
	boolean update(BoardDTO upadteDto);
	boolean create(BoardDTO insertDto);
	boolean delete(BoardDTO deleteDto); 
	
	boolean hitUpdate(int bno);
	
	//댓글
	boolean reply(BoardDTO replyDto);
	
	int getTotalRows(SearchDTO searchDTO);
}
