//package com.KoreaIT.example.JAM.test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class JDBCUpdateTEST {
//	public static void main(String args[]) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//
//		Scanner sc = new Scanner(System.in);
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			String url = "jdbc:mysql://127.0.0.1:3306/article_manager?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
//
//			conn = DriverManager.getConnection(url, "root", "");
//			System.out.println("연결 성공!");
//			
//			System.out.println("수정할 게시물 번호 : ");
//			int id = Integer.parseInt(sc.nextLine());
//			System.out.println("제목 : ");
//			String title = sc.nextLine();
//			System.out.println("내용 : ");
//			String body = sc.nextLine();
//			
//			String sql = "UPDATE article ";
//			sql += "SET updateDate = NOW(),";
//			sql += "title = '" + title + "', ";
//			sql += "`body` = '" + body + "' ";
//			sql += "WHERE id = "+ id +";";
//			
//			System.out.println(sql);
//			
//			pstmt = conn.prepareStatement(sql);
//			
//			int affectedRows = pstmt.executeUpdate();
//			
//			System.out.println("affectedRows : " + affectedRows);
//			
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로딩 실패");
//		} catch (SQLException e) {
//			System.out.println("에러: " + e);
//		} finally {
//			try {
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			try {
//				if (pstmt != null && !pstmt.isClosed()) {
//					pstmt.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//}