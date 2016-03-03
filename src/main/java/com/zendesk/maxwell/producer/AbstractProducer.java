package com.zendesk.maxwell.producer;

import com.zendesk.maxwell.MaxwellContext;
import com.zendesk.maxwell.RowMap;
import com.zendesk.maxwell.filter.MaxwellColumnFilter;

public abstract class AbstractProducer {
	protected final MaxwellContext context;
	protected final MaxwellColumnFilter filter;
	protected Boolean isFilterRequired=false;

	public AbstractProducer(MaxwellContext context, MaxwellColumnFilter filter) {
		this.context = context;
		this.filter=filter;
		this.isFilterRequired=context.getConfig().isFilterRequired;
	}

	abstract public void push(RowMap r) throws Exception;
}
