package service.validaton;

import javax.enterprise.context.Dependent;

@Dependent
public class Validator implements ValidatorInterface {

	@Override
	public boolean dataLengthCheck(String data) {
		// TODO Auto-generated method stub
		boolean flag = false;
		int validatorDataLength = 8;

		if (data.length() > validatorDataLength) {
			flag = true;
		}

		return flag;
	}

}
