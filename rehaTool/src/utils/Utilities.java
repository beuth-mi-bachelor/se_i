package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import projects.Project;
import user.User;
import views.TableDisplayItem;
import views.TableInterface;
import contests.Contest;
import contests.Prize;

public class Utilities {

	public static String dateToTextfield(Date date) {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		return format.format(date);
	}

	public static Object[] getColumnHeader(List<TableInterface> data) {
		return data.get(0).getColumn();
	}

	public static Object[][] getColumnRows(List<TableInterface> data,
			int ColumnHeadLength) {
		Object[][] rows = new Object[data.size()][ColumnHeadLength];

		for (int i = 0; i < data.size(); i++) {
			TableInterface item = data.get(i);
			Object[] tempItem = item.getRow();
			rows[i] = tempItem;
		}
		return rows;
	}

	public static TableDisplayItem getTableData(List<TableInterface> data) {
		Object[] heads = getColumnHeader(data);
		Object[][] rows = getColumnRows(data, heads.length);
		return new TableDisplayItem(heads, rows);
	}

	public static List<TableInterface> convertUserList(List<User> list) {
		return new ArrayList<TableInterface>(list);
	}

	public static List<TableInterface> convertProjectList(List<Project> list) {
		return new ArrayList<TableInterface>(list);
	}

	public static List<TableInterface> convertContestList(List<Contest> list) {
		return new ArrayList<TableInterface>(list);
	}

	public static List<TableInterface> convertPrizeList(List<Prize> list) {
		return new ArrayList<TableInterface>(list);
	}

}
