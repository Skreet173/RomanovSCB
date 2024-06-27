package modelData.usersData;

import lombok.Data;

import java.util.List;
@Data
public class ResponseModel {
	private List<ResultsItem> results;
	private Info info;
}