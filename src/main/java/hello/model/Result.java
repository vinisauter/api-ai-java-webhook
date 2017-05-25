package hello.model;

import java.util.HashMap;

/**
 * Created by Vinicius Sauter on 25/05/2017.
 * ...
 */
public class Result {
    private String source;
    private String resolvedQuery;
    private String action;
    private boolean actionIncomplete;
    private HashMap<String, String> parameters;

    public String getResolvedQuery() {
        return resolvedQuery;
    }

    public void setResolvedQuery(String resolvedQuery) {
        this.resolvedQuery = resolvedQuery;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }
}
