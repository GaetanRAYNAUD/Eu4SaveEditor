package fr.graynaud.eu4saveeditor.common;

import fr.graynaud.eu4saveeditor.service.object.data.DataType;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Keys {

    private static final Set<String> GAMESTATE_IGNORED_KEYS = Stream.of("trade={", "unit_templates={",
                                                                        "used_client_names={", "id_counters={",
                                                                        "production_leader_tag={",
                                                                        "dynamic_countries={",
                                                                        "tradegoods_total_produced={", "dynasty={",
                                                                        "great_powers={", "income_statistics={",
                                                                        "nation_size_statistics={",
                                                                        "score_statistics={", "inflation_statistics={",
                                                                        "sub_unit={", "active_relations={",
                                                                        "previous_monarch={", "ai={",
                                                                        "adm_spent_indexed={", "mil_spent_indexed={",
                                                                        "opinion_cache={", "inflation_history={",
                                                                        "ledger={").collect(Collectors.toSet());

    private Keys() {
    }

    public static Boolean ignoredKeyGamestateContains(String key) {
        return GAMESTATE_IGNORED_KEYS.contains(key);
    }

    public static DataType getTypeGamestate(String key) {
        switch (key) {
            case "start_date":
            case "date":
            case "trading_policy_date":
            case "most_recent_treasure_ship_passage":
            case "schools_initiated":
            case "dlh_bahlul_lodi_flag":
            case "plc_union_outcome_flag":
            case "mol_hungarian_march":
            case "enable_stop_shadow_kingdom":
            case "wih_meerabai_flag":
            case "wih_barbaracilli_flag":
            case "wih_eleniethiopia_flag":
            case "death_of_shah_rukh":
            case "constantinople_restored":
            case "lollard_heresy":
            case "wih_caterina_sforza_flag":
            case "coptic_qasr_ibrim_liberated":
            case "new_world_discovered":
            case "italy_out_of_HRE":
            case "wih_anacaona_flag":
            case "wih_lucreziaborgia_flag":
            case "wih_suriyothai_flag":
            case "wih_heonanseolheon_flag":
            case "no_legatus_natus":
            case "no_primas_germaniae":
            case "counter_reformation":
            case "wih_anneboleyn_flag":
            case "wih_dorotheasaxelauenburg_flag":
            case "wih_inesdesuarez_flag":
            case "triangle_happened":
            case "wih_kenausimonsdochterhasselaer_flag":
            case "dorgon_flag":
            case "hagia_sophia_now_mosque":
            case "japan_has_encountered_the_west":
            case "death_of_haji_giray":
            case "wih_safiyesultan_flag":
            case "circumnavigation_completed":
            case "wih_lamalince_flag":
            case "inc_smallpox":
            case "wih_roxelana_tur_flag":
            case "eth_start_of_the_oromo":
            case "last_janissary_spawn":
            case "expiry_date":
            case "enable":
            case "crusade_start":
            case "last_excom":
            case "birth_date":
            case "defender_date":
            case "last_estate_grant":
            case "last_looted":
            case "province_had_influenza":
                return DataType.DATE;

            case "current_age":
            case "area":
            case "which":
            case "definitions":
            case "trading_policy":
            case "name":
            case "key":
            case "heretic":
            case "religion":
            case "culture":
            case "independence":
            case "first":
            case "second":
            case "original_culture":
            case "original_religion":
            case "trade_goods":
            case "action_token":
            case "actor":
            case "likely_rebels":
            case "recipient":
            case "hostile_core_creation_desc":
                return DataType.STRING;

            case "country":
            case "emperor":
            case "tag":
            case "papal_state":
            case "crusade_target":
            case "previous_controller":
            case "owner":
            case "add_core":
            case "territorial_core":
            case "hostile_core_creation_tag":
                return DataType.TAG;

            case "speed":
            case "multiplayer_random_seed":
            case "multiplayer_random_count":
            case "num_collectors":
            case "duration":
            case "seed":
            case "rank":
            case "government_rank":
            case "reform_level":
            case "hre_leagues_status":
            case "hre_religion_status":
            case "amount_of_provinces":
            case "weighted_cardinal":
            case "dead_roc":
            case "random":
            case "any_target_province":
            case "skill":
            case "patrol":
            case "improve_count":
            case "winter":
            case "previous_winter":
            case "center_of_trade":
            case "builder":
            case "building":
            case "direction":
            case "nationalism":
            case "native_ferocity":
            case "native_hostileness":
            case "original_total":
            case "num_of_captured_ships_with_boarding_doctrine":
            case "score_place":
            case "adm_tech":
            case "dip_tech":
            case "mil_tech":
                return DataType.LONG;

            case "province":
            case "location":
            case "province_id":
            case "from_province":
            case "fort_influencing":
            case "to_province":
            case "to":
                return DataType.PROVINCE_ID;

            case "next_age_progress":
            case "prosperity":
            case "total_military_power":
            case "average_military_power":
            case "current":
            case "local_value":
            case "outgoing":
            case "value_added_outgoing":
            case "retention":
            case "steer_power":
            case "total":
            case "p_pow":
            case "max":
            case "collector_power":
            case "pull_power":
            case "retain_power":
            case "highest_power":
            case "max_demand":
            case "val":
            case "prev":
            case "max_pow":
            case "add":
            case "province_power":
            case "power_fraction":
            case "money":
            case "already_sent":
            case "power":
            case "power_modifier":
            case "potential":
            case "potential_heir_religion":
            case "civil_war_progress":
            case "consort_dipVar":
            case "consort_milVar":
            case "new_ruler_culture":
            case "new_ruler_religion":
            case "other_advisor_religion":
            case "num_converted_religion":
            case "t_in":
            case "t_out":
            case "ship_power":
            case "pirate_hunt":
            case "privateer_mission":
            case "privateer_money":
            case "current_price":
            case "total_privateer_power":
            case "progress":
            case "imperial_influence":
            case "reform_desire":
            case "papal_investment":
            case "missionary_progress":
            case "max_speed":
            case "base_tax":
            case "base_production":
            case "base_manpower":
            case "trade_power":
            case "cost":
            case "devastation":
            case "extra_cost":
            case "garrison":
            case "local_autonomy":
            case "native_size":
            case "original_tax":
            case "hostile_core_creation_cost":
            case "corruption":
            case "manpower":
            case "max_manpower":
            case "sailors":
            case "max_sailors":
            case "innovativeness":
            case "government_reform_progress":
            case "estimated_monthly_income":
            case "treasury":
            case "stability":
            case "prestige":
            case "average_home_autonomy":
            case "average_autonomy_above_min":
            case "average_autonomy":
            case "average_effective_unrest":
            case "average_unrest":
            case "inland_sea_ratio":
                return DataType.DOUBLE;

            case "used_client_names":
            case "players_countries":
            case "top_provinces":
            case "potential_incidents":
            case "\"germanic\"":
            case "\"british\"":
            case "\"french\"":
            case "\"west_slavic\"":
            case "\"carpathian\"":
            case "\"baltic\"":
            case "\"maghrebi\"":
            case "\"iranian\"":
            case "\"altaic\"":
            case "\"malay\"":
            case "\"southeastasian_group\"":
            case "\"western_aryan\"":
            case "\"southern_african\"":
            case "\"great_lakes_group\"":
            case "\"african\"":
            case "\"cushitic\"":
            case "\"evenks\"":
            case "reforms":
            case "completed_missions":
                return DataType.LIST_STRING;

            case "top_power":
                return DataType.LIST_TAG;

            case "cores":
            case "claims":
            case "production_leader_tag":
            case "dynamic_countries":
            case "electors":
            case "colony_claim":
                return DataType.LINE_TAG;

            case "setgameplayoptions":
            case "id_counters":
            case "possible_provinces":
            case "score_rank":
                return DataType.LINE_LONG;

            case "institution_origin":
                return DataType.LINE_PROVINCE_ID;

            case "institutions_penalties":
            case "trade_goods_size":
            case "top_power_values":
            case "top_provinces_values":
            case "tradegoods_total_produced":
                return DataType.LINE_DOUBLE;

            case "has_trader":
            case "has_state_patriach":
            case "has_state_pasha":
            case "has_capital":
            case "trade_company_region":
            case "recalc_defection":
            case "imperial_ban_allowed":
            case "internal_hre_cb":
            case "hre_inheritable":
            case "allows_female_emperor":
            case "tbk":
            case "hre_religion":
            case "original_hre_religion":
            case "hre_heretic_religion":
            case "original_hre_heretic_religion":
            case "papacy_active":
            case "scope_is_valid":
            case "center_of_religion":
            case "hre":
            case "is_city":
            case "discover":
            case "hre_liberated":
            case "mothball_command":
            case "once":
            case "permanent":
            case "ub":
            case "user_changed_name":
                return DataType.BOOL;

            default:
                return Keys2.getTypeGamestate(key);
        }
    }
}
