package org.domingus.logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Reader {
	
	private String path;

	public Reader(String path) {
		this.path = path;
	}
	
	public List<Log> readAll() {
        try {
            File file = new File(path);
            if (file .exists()) {
                String data = Files.readString(Path.of(path));
                ObjectMapper objectMapper = new ObjectMapper();
                return objectMapper.readValue(data, new TypeReference<List<Log>>() {});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Log>();
    }

}