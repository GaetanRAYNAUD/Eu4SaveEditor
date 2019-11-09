package fr.graynaud.eu4saveeditor.common;

import fr.graynaud.eu4saveeditor.service.object.data.DataType;

public final class Keys {

    private Keys() {
    }

    public static DataType getType(String key) {
        switch (key) {
            case "date":
                return DataType.DATE;

            case "save_game":
            case "player":
            case "displayed_country_name":
            case "campaign_id":
            case "checksum":
            case "name":
            case "key":
            case "selector":
            case "localization":
                return DataType.STRING;

            case "savegame_version":
                return DataType.OBJECT;

            case "first":
            case "second":
            case "third":
            case "forth":
            case "campaign_length":
            case "id":
            case "comparison":
            case "sample_count":
                return DataType.INT;

            case "savegame_versions":
            case "dlc_enabled":
            case "mod_enabled":
                return DataType.LIST_STRINGS;

            case "multi_player":
            case "not_observer":
                return DataType.BOOL;

            case "campaign_stats":
                return DataType.LIST_OBJECTS;

            default:
                return DataType.UNKNOWN; //If UNKNOWN, DataType.getType(value), mostly because a key can have multiple types (ex: value)
        }
    }
}
