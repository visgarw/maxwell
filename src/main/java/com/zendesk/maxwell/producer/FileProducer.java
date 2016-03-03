package com.zendesk.maxwell.producer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.zendesk.maxwell.MaxwellAbstractRowsEvent;
import com.zendesk.maxwell.MaxwellContext;
import com.zendesk.maxwell.RowMap;
import com.zendesk.maxwell.filter.MaxwellColumnFilter;

public class FileProducer extends AbstractProducer {
	private final File file;
	private final FileWriter fileWriter;

	public FileProducer(MaxwellContext context, String filename, MaxwellColumnFilter filter) throws IOException {
		super(context, filter);
		this.file = new File(filename);
		this.fileWriter = new FileWriter(this.file, true);
		this.isFilterRequired=context.getConfig().isFilterRequired;
		
	}

	@Override
	public void push(RowMap r) throws Exception {
	    if(isFilterRequired){
            filter.applyFilter(r);
        }
		this.fileWriter.write(r.toJSON());
		this.fileWriter.write('\n');
		this.fileWriter.flush();

		context.setPosition(r);
	}

}
