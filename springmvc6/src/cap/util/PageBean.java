package cap.util;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

public class PageBean {

	public static final int NUMBERS_PER_PAGE = 5;
	private int page, totalPages;
	@SuppressWarnings("rawtypes")
	private List resultList;

	@SuppressWarnings("rawtypes")
	public static PageBean queryByPage(String sql, int currentPage,
			int numPerPage, JdbcTemplate jdbcTemplate) {
		PageBean pageBean = new PageBean();
		String countSQL = getSQLCount(sql);
		pageBean.setPage(currentPage);
		Integer totalCount = jdbcTemplate.queryForObject(countSQL,
				Integer.class);
		pageBean.setTotalPage(numPerPage, totalCount);
		int startIndex = (currentPage - 1) * numPerPage;
		StringBuffer paginationSQL = new StringBuffer(" ");
		paginationSQL.append(sql);
		paginationSQL.append(" limit " + startIndex + "," + numPerPage);
		List resultLists = jdbcTemplate.queryForList(paginationSQL.toString());
		pageBean.setResultList(resultLists);
		return pageBean;
	}

	public static String getSQLCount(String sql) {
		String sqlBak = sql.toLowerCase();
		String searchValue = " from ";
		String sqlCount = "select count(*) "
				+ sql.substring(sqlBak.indexOf(searchValue));
		return sqlCount;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public void setTotalPage(int numPerPage, int totalCount) {
		if (totalCount % numPerPage == 0) {
			this.totalPages = totalCount / numPerPage;
		}else {
			this.totalPages = totalCount / numPerPage + 1;
		}
	}

}
