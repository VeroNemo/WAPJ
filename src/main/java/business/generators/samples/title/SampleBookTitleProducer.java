package business.generators.samples.title;

import javax.enterprise.inject.Produces;

import persistence.qualifiers.Fake;
import persistence.qualifiers.Real;

public class SampleBookTitleProducer {
	
	@Produces @Fake
	public String produceFakeBookTitle() {
		return "This is obviosly a fake title";
	}
	
	@Produces @Real
	public String produceRealBookTitle( ) {
		return "Beggining Java EE";
	}

}
