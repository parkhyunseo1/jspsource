package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

// ~~~DAO : DB 서버와 연동해서 DB 작업 담당하는 클래스
// 1. 드라이버 로드
// 2. 커넥션(DB서버) 얻기
// 3. 커넥션을 통해 CRUD(insert, read, update, delete) 작업실행


// Statement : SQL 의 DDL, DML 실행할 때 사용(정적 SQL 문 실행 시 사용 - DELETE FROM usertb1 WHERE id=1)
//			   동적 SQL 구문 사용 시 SQL injection(DB 서버 공격)발생할 수 있음
// PreparedStatement : Statement 와 기능 동일(동적 SQL 문 실행 시 사용 - DELETE FROM usertb1 WHERE id=?)
//                     ? 로 값을 넣기 때문에 편리성, 보안성이 좋다.


// ResultSet : SELECT 결과가 담기는 객체
public class MemberDao {

	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	
		// 연결문자열 => DriverManager
		public Connection getConnection() throws SQLException  {
			// localhost(== 127.0.0.1) : 오라클 서버가 설치된 ip 주소
			// 1521 : 오라클 기본포트
			// xe : 오라클 Express Edition 설치 시 기본 설치되는 데이터 베이스 이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "c##java";
			String password = "12345";
			
			return DriverManager.getConnection(url, user, password);
			
		}
		// 자원해제
		public void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
		public void close(Connection con, PreparedStatement pstmt) {
			try {
				if(pstmt!=null)pstmt.close();
				if(con!=null)con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		// CRUD 메소드
//		public int create(String userid,String name,String password,int age,String email) {
//			int result = 0;
//			try {
//				
//				//커넥션 얻기
//				con = getConnection();
//				
//				//sql구문 작성 후 db 서버로 보내기
//				String sql = "INSERT INTO usertbl(userid,name,password,age,email) "
//				+"VALUES(?,?,?,?,?)";
//				
//				pstmt = con.prepareStatement(sql);
//				//? 해결
//				pstmt.setString(1, userid);
//				pstmt.setString(2, name);
//				pstmt.setString(3, password);
//				pstmt.setInt(4, age);
//				pstmt.setString(5, email);
//				
//				// sql구문 실행
//				result = pstmt.executeUpdate();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close(con, pstmt);
//			}
//		
//				return result;
//			
//		}
		// CRUD 메소드
		public int create(MemberDTO insertDto) {
			int result = 0;
			try {
				
				//커넥션 얻기
				con = getConnection();
				
				//sql구문 작성 후 db 서버로 보내기
				String sql = "INSERT INTO usertbl(userid,name,password,age,email) "
				+"VALUES(?,?,?,?,?)";
				
				pstmt = con.prepareStatement(sql);
				//? 해결
				pstmt.setString(1, insertDto.getUserid());
				pstmt.setString(2, insertDto.getName());
				pstmt.setString(3, insertDto.getPassword());
				pstmt.setInt(4, insertDto.getAge());
				pstmt.setString(5, insertDto.getEmail());
				
				// sql구문 실행
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt);
			}
		
				return result;
			
		}
		
		
	
	

		public void read() {
			
			
		}
		public MemberDTO login(MemberDTO dto) {
			
			MemberDTO loginDto = null;
			try {
				
				con = getConnection();
				
				//sql 구문 작성후 db서버로 보내기
				String sql = "SELECT USERID,NAME FROM USERTBL u WHERE USERID =? AND PASSWORD = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, dto.getUserid());
				pstmt.setString(2, dto.getPassword());
				
				rs = pstmt.executeQuery();
				
				// rs에 담긴 내용을 ~~DTO 로 옮기기
				if (rs.next()) {
					loginDto = new MemberDTO();
//					String userid = rs.getString(1);
//					String name = rs.getString(2);
					loginDto.setUserid(rs.getString(1));
					loginDto.setName(rs.getString(2));
					
					
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(con, pstmt, rs);
			}
			return loginDto;
		}
		public void update() {
			
			
		}
		
		public void delete() {
			
			
		}
}
