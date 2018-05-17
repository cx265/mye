package priv.cx.carl.imageUtil;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 作者:chenxuan E-mail:chenx265@163.com
 * @version 创建时间：2017年4月11日 下午5:00:41
 */
public class ImageDemo_1 {

	// 将图片插入数据库
	public static void readImage2DB() {
		String path = "D:/1.png";
		Connection conn = null;
		PreparedStatement ps = null;
		FileInputStream in = null;
		try {
			in = ImageUtil_1.readImage(path);
			conn = DBUtil.getConn();
			String sql = "insert into photo (id,name,photo)values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			ps.setString(2, "Tom");
			ps.setBinaryStream(3, in, in.available());
			int count = ps.executeUpdate();
			if (count > 0) {
				System.out.println("插入成功！");
			} else {
				System.out.println("插入失败！");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
			if (null != ps) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 读取数据库中图片
	public static void readDB2Image() {
		String targetPath = "D:/image/1.png";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select * from photo where id =?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, 1);
			rs = ps.executeQuery();
			while (rs.next()) {
				InputStream in = rs.getBinaryStream("photo");
				ImageUtil_1.readBin2Image(in, targetPath);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn);
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}

	// 测试
	public static void main(String[] args) {
		// readImage2DB();
		readDB2Image();
	}
}
