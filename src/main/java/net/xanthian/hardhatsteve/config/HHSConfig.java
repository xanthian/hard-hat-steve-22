package net.xanthian.hardhatsteve.config;

import com.mojang.datafixers.util.Pair;
import net.xanthian.hardhatsteve.HardHatSteve;

import java.util.ArrayList;
import java.util.List;

public class HHSConfig implements SimpleConfig.DefaultConfig {

    private String configContents =     """
                ###############################
                # ONLY MAKE 1 VALUE = TRUE    #
                # ELSE THE MOD WILL NOT LOAD  #
                ###############################
                """;

    public List<Pair> getConfigsList() {
        return configsList;
    }

    private final List<Pair> configsList = new ArrayList<>();

    public void addKeyValuePair(Pair<String, Double> keyValuePair) {
        configsList.add(keyValuePair);
        configContents +="\n"+ keyValuePair.getFirst() + "=" + keyValuePair.getSecond() + "\n";
    }

    @Override
    public String get(String namespace) {
        return configContents;
    }
    public static SimpleConfig CONFIG;
    private static HHSConfig configs;
    public static double reach;

    public static void registerConfigs() {
        configs = new HHSConfig();
        createConfigs();
        CONFIG = SimpleConfig.of(HardHatSteve.MOD_ID + "_config").provider(configs).request();
        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("reach",0.5));
    }

    private static void assignConfigs() {
        reach = CONFIG.getOrDefault("reach", 0.5);
    }
}