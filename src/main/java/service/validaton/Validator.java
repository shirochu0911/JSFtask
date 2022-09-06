package service.validaton;

import javax.enterprise.context.Dependent;

@Dependent
public class Validator implements ValidatorInterface {

	@Override
	public String dataLengthCheck(String data) {
		// TODO Auto-generated method stub
		int validatorDataLength = 8;
		String errorMessage = null;

		if (data.length() > validatorDataLength) {
			errorMessage = "想定している文字数を超えています";
		}

		return errorMessage;
	}

}
