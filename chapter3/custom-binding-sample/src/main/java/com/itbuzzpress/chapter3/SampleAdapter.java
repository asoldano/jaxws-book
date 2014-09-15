package com.itbuzzpress.chapter3;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class SampleAdapter extends XmlAdapter<String, SampleBean> {

	@Override
	public String marshal(SampleBean v) throws Exception {
		return v.getFistAttribute() + "-" + v.getSecondAttribute();
	}

	@Override
	public SampleBean unmarshal(String v) throws Exception {
		SampleBean b = new SampleBean();
		b.setFistAttribute(v.substring(0, v.indexOf('-')));
		b.setSecondAttribute(Long.valueOf(v.substring(v.indexOf('-') + 1)));
		return b;
	}
}
