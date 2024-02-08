package rest.helper;

import lombok.extern.log4j.Log4j;
import rest.BaseClient;

@Log4j
public class GetHelper {

    BaseClient baseClient;

    public GetHelper(BaseClient baseClient) {
        this.baseClient = baseClient;
    }
}


