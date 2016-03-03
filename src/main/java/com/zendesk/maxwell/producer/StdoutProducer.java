package com.zendesk.maxwell.producer;

import com.zendesk.maxwell.MaxwellContext;
import com.zendesk.maxwell.RowMap;
import com.zendesk.maxwell.filter.MaxwellColumnFilter;

public class StdoutProducer extends AbstractProducer {
	public StdoutProducer(MaxwellContext context, MaxwellColumnFilter filter) {
		super(context,filter);
	}

	@Override
	public void push(RowMap r) throws Exception {
	    if(isFilterRequired){
            filter.applyFilter(r);
        }
		System.out.println(r.toJSON());
		this.context.setPosition(r);
	}

}
