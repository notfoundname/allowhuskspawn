package com.notfoundname.allowhuskspawn.horizon;

import io.canvasmc.horizon.HorizonLoader;
import io.canvasmc.horizon.service.entrypoint.DedicatedServerInitializer;

public class HorizonInit implements DedicatedServerInitializer {
    @Override
    public void onInitialize() {
        HorizonLoader.LOGGER.info("AllowHuskSpawn initialized!");
    }
}
