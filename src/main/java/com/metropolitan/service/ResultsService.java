package com.metropolitan.service;

import com.metropolitan.model.Results;
import com.metropolitan.model.dto.ResultsHelper;


import java.util.List;

public interface ResultsService {
    public Results createResults(ResultsHelper results);

    public List<Results> getAllResults();

}
