package service;

import java.util.List;

import dao.BoardDAO;
import dto.BoardDTO;
import dto.SearchDTO;

public class BoardServiceImpl implements BoardService {

	private BoardDAO dao = new BoardDAO();
		
	@Override
	public List<BoardDTO> listAll(SearchDTO searchDTO) {
		// TODO Auto-generated method stub
		return dao.getList(searchDTO);
	}

	@Override
	public BoardDTO getRow(int bno) {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}
	@Override
	public boolean delete(BoardDTO deleteDto) {
		// TODO Auto-generated method stub
		return dao.delete(deleteDto)==1?true:false;
	}

	@Override
	public boolean update(BoardDTO upadteDto) {
		// TODO Auto-generated method stub
		return dao.update(upadteDto)==1?true:false;
	}

	@Override
	public boolean create(BoardDTO insertDto) {
		// TODO Auto-generated method stub
		return dao.insert(insertDto)==1?true:false;
	}

	@Override
	public boolean hitUpdate(int bno) {
		// TODO Auto-generated method stub
		return dao.updateReadCnt(bno)==1?true:false;
	}

	@Override
	public boolean reply(BoardDTO replyDto) {
		// TODO Auto-generated method stub
		return dao.replyinsert(replyDto) ==1?true:false;
	}

	@Override
	public int getTotalRows() {
		// TODO Auto-generated method stub
		return dao.getTotalRows();
	}

}
