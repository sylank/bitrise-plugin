package io.bitrise.plugins.service;

import java.io.IOException;
import java.util.List;

public interface AppService {
    List getUserApps() throws IOException;
}
