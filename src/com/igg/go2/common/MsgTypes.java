package com.igg.go2.common;

/**
 * This class appears to contain most constants regarding limits and message data types.<br/>
 * All constant names prefixed with <code>_MSG</code> in the source have been renamed to <code>MSG</code> to fit convention.</code><br/>
 * All <code>MSG</code> constants have been changed from type <code>int</code> to type <code>short</code> for convenience.<br/>
 * Ported by SkimnerPhi
 * @author IGG
 */
public class MsgTypes {
  private static MsgTypes instance;
  
  public static final int MAP_RANGE = 420;
  public static final int MAX_NAME = 32;
  public static final int MAX_MEMO = 256;
  public static final int CHAT_MESSAGE = 128;
  public static final int VALIDATECODE_LENGTH = 25;
  public static final int SESSIONKEY_LENGTH = 128;
  public static final int MAX_GAMESERVERLIST = 60;
  public static final int FIGHTSTARMATRIX = 4;
  public static final int MAX_CREATECONSORTIALEVEL = 8;
  public static final int TECHSTART_CONSORTIA = 201;
  public static final int TECHSTART_CAMP = 101;
  public static final int MAX_MAP_ROW = 25;
  public static final int MAX_MAP_COL = 25;
  public static final int MAX_BUILDING = 200;
  public static final int MAX_SHIPPART = 50;
  public static final int MAX_SHIPTEAMBODY = 9;
  public static final int SHIPMODEL_TECH = 5;
  public static final int MAX_SHIPMODEL = 30;
  public static final int MAX_SHIPCREATING = 5;
  public static final int MAX_SHIPDISTYPE = 200;
  public static final int MIN_HOLDSTAR = 0;
  public static final int MAX_ADJUTANTNUM = 30;
  public static final int MAX_COMMANDNUM = 30;
  public static final int MAX_USERSHIPTEAMNUM = 60;
  public static final int MAX_GALAXYSTARNUM = 50;
  public static final int MAX_874_COUNT = 5;
  public static final int MAX_874_ALLCOUNT = 20;
  /**
   * <code>MAX_874_Additional</code> in source
   */
  public static final int MAX_874_ADDITIONAL = 5;
  public static final int MAX_FIGHTRESULTEXP = 10;
  public static final int MAX_FIGHTRESULTKILL = 10;
  public static final int MAX_FIGHTRESULTPRIZE = 10;
  public static final int MAX_GALAXYCAMP = 80;
  public static final int MAX_FIGHTMOVEPATH = 16;
  public static final int MAX_CAMP = 7;
  public static final int MAX_MSG_PART = 7;
  public static final int MAX_SENDTEAMINFO = 189;
  /**
   * <code>MAX_CHATFRIEDN</code> in source
   */
  public static final int MAX_CHATFRIEND = 50;
  public static final int MAX_DATETIME = 20;
  public static final int MAX_MATRIXSHIP = 3000;
  public static final int MAX_VALIDSHIP = 1000;
  public static final int MAX_CAMPLOCKNUM = 30;
  public static final int MAX_DOWNLOADURL = 60;
  public static final int MAX_TRADECOUNT = 20;
  public static final int MAX_VOTEPERSON = 50;
  public static final int MAX_CONSORTIAFIELD = 10;
  public static final int MAX_OFFICIALCOUNT = 4;
  /**
   * <code>MaxDeadShipData</code> in source
   */
  public static final int MAX_DEADSHIPDATA = 90;
  public static final int CLIENTMAXLOADAREA = 9;
  public static final int MAX_CREATESHIPLIST = 10;
  public static final int AREAGRIDX = 10;
  public static final int AREAGRIDY = 10;
  public static final int GRIDPIXELX = 80;
  public static final int GRIDPIXELY = 80;
  public static final int AREAGRID = AREAGRIDX * AREAGRIDY;
  public static final int MAX_MAPAREA = 10;
  public static final int MAX_MAPAREAGRID = AREAGRIDY * MAX_MAPAREA;
  public static final int CITYMAPWIDTH = 1600;
  public static final int CITYMAPHEIGHT = 1200;
  public static final int COMMANDERZJCOUNT = 8;
  public static final int MAX_SHIPBODYUPGRADELIST = 1;
  public static final int MAX_COMMANDERNUM = 60;
  public static final int MAX_TEAMMODEL = 3;
  public static final int MAX_RANKPAGELEN = 6;
  public static final int MAX_MSGFRIENDLEN = 100;
  public static final int MAX_EMAILCONTENT = 512;
  public static final int MAX_EMAILGOODS = 100;
  public static final int MAX_FIELDRESOURCE = 12;
  
  public static final int CT_WORLD = 0;
  public static final int CT_CAMP = 1;
  public static final int CT_GALAXY = 2;
  public static final int CT_CONSORTIA = 3;
  public static final int CT_PRIVATE = 4;
  public static final int CT_SCRIPT = 5;
  public static final int CT_SYSTEM = 6;
  public static final int CT_CAMPNOTICE = 7;
  public static final int CT_OTHER = 8;
  public static final int CT_GMNOTICE = 9;
  
  public static final int MAP_WORLD = 0;
  
  public static final int SST_STARTUSTEE = 0;
  public static final int SST_MINERAL = 1;
  public static final int SST_GAS = 2;
  public static final int SST_POPULATION = 3;
  public static final int SST_TECH = 4;
  public static final int SST_BUILDINGSPEED = 5;
  public static final int SST_JUMPSPEED = 6;
  public static final int SST_BUILDSHIPSPEED = 7;
  public static final int SST_EMPOLDERBASW = 8;
  public static final int SST_COMMANDUPPERLIMIT = 9;
  public static final int SST_STARUPPERLIMIT = 10;
  public static final int SST_LOOKONBATTLE = 11;
  public static final int SST_ACTIVESHIPNUM = 12;
  
  public static final int CT_NONE = -1;
  public static final int CT_NPC = 0;
  public static final int CT_COUNTRY1 = 1;
  public static final int CT_COUNTRY2 = 2;
  public static final int CT_COUNTRY3 = 3;
  public static final int CT_COUNTRY4 = 4;
  public static final int CT_COUNTRY5 = 5;
  public static final int CT_COUNTRY6 = 6;
  public static final int CT_COUNT = 7;
  
  /**
   * <code>JOB_Civilian</code> in source
   */
  public static final int JOB_CIVILIAN = 0;
  /**
   * <code>JOB_State</code> in source
   */
  public static final int JOB_STATE = 1;
  /**
   * <code>JOB_Defence</code> in source
   */
  public static final int JOB_DEFENCE = 2;
  /**
   * <code>JOB_Interior</code> in source
   */
  public static final int JOB_INTERIOR = 3;
  /**
   * <code>JOB_Member</code> in source
   */
  public static final int JOB_MEMBER = 4;
  /**
   * <code>JOB_Staff</code> in source
   */
  public static final int JOB_STAFF = 5;
  /**
   * <code>JOB_Scholar</code> in source
   */
  public static final int JOB_SCHOLAR = 6;
  /**
   * <code>JOB_Leader</code> in source
   */
  public static final int JOB_LEADER = 7;
  
  public static final int SERVICESITEM_NUM = 12;
  
  public static final int CT_STARTYPE1 = 1;
  public static final int CT_STARTYPE2 = 2;
  public static final int CT_STARTYPE3 = 3;
  public static final int CT_STARTYPE4 = 4;
  public static final int CT_STARTYPE5 = 5;
  
  public static final int TEAMBODY_NUM = 9;
  
  public static final int DIRECTION_RIGHT = 0;
  public static final int DIRECTION_DOWN = 1;
  public static final int DIRECTION_LEFT = 2;
  public static final int DIRECTION_UP = 3;
  
  public static final int SHIP_ASSAULT = 1;
  public static final int SHIP_CRUISER = 2;
  public static final int SHIP_WARSHIP = 3;
  
  public static final int BUILD_NEWBUILD = -1;
  public static final int BUILD_QUICKBUILD = 0;
  public static final int MAX_HELPCOUNT = 8;
  public static final int MAX_FRIENDFIELDSTATUS = 6;
  public static final int MAX_NAME_LEN = 8;
  public static final int MSGBUFFERPOS_HEAD = 0;
  public static final int MSGBUFFERPOS_TYPE = 2;
  /**
   * <code>MAX_COMMANDERSTORE</code> in source
   */
  public static final int MAX_COMMANDERSTONE = 12;
  public static final int HONOR_PROPOS_ID = 931;
  
  public static final int CMS_YOUR = 0;
  public static final int CMS_NORMALCOMMANDER = 1;
  public static final int CMS_SPELLCOMMANDER = 2;
  public static final int CMS_SPECIALCOMMANDER = 3;
  public static final int CMS_SUPERCOMMANDER = 4;
  public static final int CMS_NORMALCREATE = 0;
  public static final int CMS_SPECIALCREATE = 1;
  public static final int CMS_SUPERCREATE = 2;
  public static final int CMS_NORMAL = 0;
  public static final int CMS_ILL = 1;
  public static final int CMS_DEATH = 2;
  public static final int CMS_FIGHT_ILLDEATH = 3;
  /**
   * <code>_COMMANDER_TYPE_FREE</code> in source
   */
  public static final int COMMANDER_TYPE_FREE = 1;
  /**
   * <code>_COMMANDER_TYPE_ALL</code> in source
   */
  public static final int COMMANDER_TYPE_ALL = 0;
  
  public static final int MAX_CMOSCOUNT = 30;
  public static final int MAX_COMMANDERCMOS = 5;

  public static final int MAX_RACINGENEMYNUM = 9;
  public static final int MAX_RACINGREPORTNUM = 5;
  public static final int MAX_RACINGSHIPTEAMNUM = 12;
  
  public static final short MSG_CLIENT_LOGINTOL = 502;
  public static final short MSG_CLIENT_LOGINTOG = 503;
  public static final short MSG_LOGINSERVER_VALIDATE = 504;
  public static final short MSG_GAMESERVER_LOGINRESP = 505;
  public static final short MSG_DBSERVER_ROLEINFO = 507;
  public static final short MSG_GAMESERVER_SENDGIFT = 514;
  public static final short MSG_GAMESERVER_USERLEVELRESP = 516;
  public static final short MSG_LOGIN = 1000;
  public static final short MSG_LOGIN_RETURN_INFO = 1001;
  public static final short MSG_REQUEST_GAMESERVER = 1002;
  public static final short MSG_VALIDATE_GAMESERVER = 1003;
  public static final short MSG_LOGIN_GAMESERVER = 1004;
  public static final short MSG_LOGIN_GAMESERVER2 = 1005;
  public static final short MSG_RESPONSE_GAMESERVER = 1006;
  public static final short MSG_ROLE_INFO = 1007;
  public static final short MSG_REQUEST_CREATEROLE = 1008;
  public static final short MSG_CREATE_ROLE = 1009;
  public static final short MSG_GAMESERVER_READY = 1010;
  public static final short MSG_ENTER_GAME = 1011;
  public static final short MSG_CLIENT_READY = 1012;
  public static final short MSG_GAMESERVER_INFO = 1013;
  public static final short MSG_REQUEST_PUSHTEST = 1014;
  public static final short MSG_RESP_CREATEROLE = 1015;
  public static final short MSG_RESP_DBREADOVER = 1016;
  public static final short MSG_REQUEST_PLAYERINFO = 1017;
  public static final short MSG_RESP_ACCOUNTAUTH = 1018;
  public static final short MSG_GAME_CLOSECLIENT = 1019;
  public static final short MSG_GAME_CLIENTACTIVE = 1020;
  public static final short MSG_LOGINSERVER_GAMESERVERLISTRESP = 1021;
  public static final short MSG_LOGINSERVER_CHECKREGISTERNAME = 1022;
  public static final short MSG_LOGINSERVER_CHECKREGISTERNAMERESP = 1023;
  public static final short MSG_REQUEST_UPDATEPLAYERNAME = 1024;
  public static final short MSG_RESP_UPDATEPLAYERNAME = 1025;
  public static final short MSG_REQUEST_CHANGESERVER = 1050;
  public static final short MSG_RESP_CHANGESERVER = 1051;
  public static final short MSG_REQUEST_PROPSMOVE = 1052;
  public static final short MSG_RESP_PROPSMOVE = 1053;
  public static final short MSG_RESP_PROPSINFO = 1054;
  public static final short MSG_REQUEST_USEPROPS = 1055;
  public static final short MSG_RESP_USEPROPS = 1056;
  public static final short MSG_REQUEST_ADDPACK = 1057;
  public static final short MSG_RESP_ADDPACK = 1058;
  public static final short MSG_REQUEST_DELETEPROPS = 1059;
  public static final short MSG_RESP_DELETEPROPS = 1060;
  public static final short MSG_RESP_MAPBLOCK = 1061;
  public static final short MSG_REQUEST_BUYGOODS = 1062;
  public static final short MSG_RESP_BUYGOODS = 1063;
  public static final short MSG_REQUEST_TASKINFO = 1064;
  public static final short MSG_RESP_TASKINFO = 1065;
  public static final short MSG_REQUEST_TASKGAIN = 1066;
  public static final short MSG_RESP_TASKGAIN = 1067;
  public static final short MSG_REQUEST_GAINDAILYAWARD = 1068;
  public static final short MSG_RESP_GAINDAILYAWARD = 1069;
  public static final short MSG_REQUEST_COMPLETEGUIDE = 1070;
  public static final short MSG_REQUEST_GAMESERVERLIST = 1071;
  public static final short MSG_RESP_GAMESERVERLIST = 1072;
  public static final short MSG_TRANSMIT_ROLEINFO = 1073;
  public static final short MSG_TRANSMIT_TASK = 1074;
  public static final short MSG_TRANSMIT_SHIPBODYINFO = 1075;
  public static final short MSG_TRANSMIT_COMMANDER = 1076;
  public static final short MSG_TRANSMIT_STAR = 1077;
  public static final short MSG_TRANSMIT_SHIPMODEL = 1078;
  public static final short MSG_TRANSMIT_DBWRITECOMPLETE = 1079;
  public static final short MSG_TRANSMIT_UPDATESERVERID = 1080;
  public static final short MSG_TRANSMIT_UPDATESERVERIDRESP = 1081;
  public static final short MSG_REQUEST_GAINLOTTERY = 1082;
  public static final short MSG_RESP_GAINLOTTERY = 1083;
  public static final short MSG_RESP_LOTTERYSTATUS = 1084;
  public static final short MSG_REQUEST_DELETESERVER = 1085;
  public static final short MSG_RESP_DELETESERVER = 1086;
  public static final short MSG_REQUEST_REFRESHWALL = 1087;
  public static final short MSG_RESP_REFRESHWALL = 1088;
  public static final short MSG_REQUEST_EXCHANGERES = 1089;
  public static final short MSG_RESP_EXCHANGERES = 1090;
  public static final short MSG_REQUEST_ONLINEAWARD = 1091;
  public static final short MSG_RESP_ONLINEAWARD = 1092;
  public static final short MSG_REQUEST_GETONLINEAWARD = 1093;
  public static final short MSG_RESP_GETONLINEAWARD = 1094;
  public static final short MSG_REQUEST_GALAXY = 1100;
  public static final short MSG_RESP_GALAXY = 1101;
  public static final short MSG_REQUEST_STAR = 1102;
  public static final short MSG_RESP_STAR = 1103;
  public static final short MSG_RESP_MOVEHOMEBRO = 1104;
  public static final short MSG_REQUEST_HOLDGALAXY = 1105;
  public static final short MSG_RESP_HOLDGALAXY = 1106;
  public static final short MSG_REQUEST_SHOWEMPTYGALAXY = 1107;
  public static final short MSG_REQUEST_UPDATESTARNAME = 1108;
  public static final short MSG_RESP_UPDATESTARNAME = 1109;
  public static final short MSG_REQUEST_MOVEHOME = 1110;
  public static final short MSG_RESP_MOVEHOME = 1111;
  public static final short MSG_FIGHTGALAXYOVER = 1112;
  public static final short MSG_RESP_GALAXYBROADCAST = 1113;
  public static final short MSG_REQUEST_THROWSTAR = 1114;
  public static final short MSG_RESP_THROWSTAR = 1115;
  public static final short MSG_REQUEST_LEAVEGALAXY = 1116;
  public static final short MSG_REQUEST_BUILDDEMANDINFO = 1117;
  public static final short MSG_RESP_BUILDDEMANDINFO = 1118;
  public static final short MSG_REQUEST_HOLDGALAXYINFO = 1119;
  public static final short MSG_RESP_HOLDGALAXYINFO = 1120;
  public static final short MSG_REQUEST_LOCKGALAXY = 1121;
  public static final short MSG_RESP_LOCKGALAXY = 1122;
  public static final short MSG_REQUEST_GALAXYLOCKINFO = 1123;
  public static final short MSG_RESP_GALAXYLOCKINFO = 1124;
  public static final short MSG_REQUEST_STARAUTOUPGRADE = 1125;
  public static final short MSG_RESP_STARAUTOUPGRADE = 1126;
  public static final short MSG_REQUEST_SPACE = 1127;
  public static final short MSG_RESP_SPACE = 1128;
  public static final short MSG_REQUEST_TREASURE = 1129;
  public static final short MSG_RESP_TREASURE = 1130;
  public static final short MSG_REQUEST_RESCHANGE = 1131;
  public static final short MSG_RESP_RESCHANGE = 1132;
  public static final short MSG_FIGHTGALAXYBEGIN = 1133;
  public static final short MSG_REQUEST_ECTYPE = 1134;
  public static final short MSG_RESP_ECTYPESTATE = 1135;
  public static final short MSG_RESP_HOMETREASURE = 1136;
  public static final short MSG_REQUEST_HOMETREASURE = 1137;
  public static final short MSG_RESP_HOMECOPYFLAG = 1138;
  public static final short MSG_REQUEST_LOCKGALAXYCAMP = 1139;
  public static final short MSG_RESP_LOCKGALAXYCAMP = 1140;
  public static final short MSG_RESP_GALAXYGOODS = 1141;
  public static final short MSG_REQUEST_LIFESHIP = 1142;
  public static final short MSG_RESP_LIFESHIP = 1143;
  public static final short MSG_REQUEST_REBUILDSTAR = 1144;
  public static final short MSG_RESP_REBUILDSTAR = 1145;
  public static final short MSG_RESP_REBUILDSTARINFO = 1146;
  public static final short MSG_REQUEST_HOMETASK = 1147;
  public static final short MSG_RESP_HOMETASKFLAG = 1148;
  public static final short MSG_RESP_HOMETASKSTATUS = 1149;
  public static final short MSG_REQUEST_GALAXYAUTOUPGRADE = 1150;
  public static final short MSG_RESP_GALAXYAUTOUPGRADE = 1151;
  public static final short MSG_REQUEST_HOMEADDSTAR = 1152;
  public static final short MSG_RESP_HOMEADDSTAR = 1153;
  public static final short MSG_REQUEST_GALAXYSHIPBUILD = 1154;
  public static final short MSG_RESP_GALAXYSHIPBUILD = 1155;
  public static final short MSG_REQUEST_GALAXYINFO = 1156;
  public static final short MSG_RESP_GALAXYINFO = 1157;
  public static final short MSG_RESP_INSERTFLAGBRO = 1158;
  public static final short MSG_REQUEST_CREATEBUILD = 1200;
  public static final short MSG_RESP_CREATEBUILD = 1201;
  public static final short MSG_REQUEST_BUILDINFO = 1202;
  public static final short MSG_RESP_BUILDINFO = 1203;
  public static final short MSG_RESP_BUILDCOMPLETE = 1204;
  public static final short MSG_REQUEST_CANCELBUILD = 1205;
  public static final short MSG_RESP_CANCELBUILD = 1206;
  public static final short MSG_REQUEST_DELETEBUILD = 1207;
  public static final short MSG_RESP_DELETEBUILD = 1208;
  public static final short MSG_REQUEST_CREATETECH = 1209;
  public static final short MSG_RESP_CREATETECH = 1210;
  public static final short MSG_REQUEST_TECHINFO = 1211;
  public static final short MSG_RESP_TECHINFO = 1212;
  public static final short MSG_REQUEST_PLAYERRESOURCE = 1213;
  public static final short MSG_RESP_PLAYERRESOURCE = 1214;
  public static final short MSG_REQUEST_TECHUPGRADEINFO = 1215;
  public static final short MSG_RESP_TECHUPGRADEINFO = 1216;
  public static final short MSG_REQUEST_CANCELTECH = 1217;
  public static final short MSG_RESP_CANCELTECH = 1218;
  public static final short MSG_RESP_CREATETECHCOMPLETE = 1219;
  public static final short MSG_REQUEST_BUILDCREATING = 1220;
  public static final short MSG_RESP_BUILDCREATING = 1221;
  public static final short MSG_REQUEST_SPEEDBUILDING = 1222;
  public static final short MSG_RESP_SPEEDBUILDING = 1223;
  public static final short MSG_REQUEST_TIMEQUEUE = 1224;
  public static final short MSG_RESP_TIMEQUEUE = 1225;
  public static final short MSG_REQUEST_CONSORTIABUILDING = 1226;
  public static final short MSG_RESP_CONSORTIABUILDING = 1227;
  public static final short MSG_REQUEST_SPEEDTECH = 1228;
  public static final short MSG_RESP_SPEEDTECH = 1229;
  public static final short MSG_REQUEST_SPEEDFRIENDBUILDING = 1230;
  public static final short MSG_RESP_SPEEDFRIENDBUILDING = 1231;
  public static final short MSG_REQUEST_GETSTORAGERESOURCE = 1232;
  public static final short MSG_RESP_GETSTORAGERESOURCE = 1233;
  public static final short MSG_REQUEST_MOVEBUILD = 1234;
  public static final short MSG_RESP_MOVEBUILD = 1235;
  public static final short MSG_REQUEST_STORAGERESOURCE = 1236;
  public static final short MSG_RESP_STORAGERESOURCE = 1237;
  public static final short MSG_RESP_BUILDINGDEATHCOMPLETE = 1238;
  public static final short MSG_RESP_CREATEBUILDINFO = 1239;
  public static final short MSG_RESP_BUILDINFOFRIEND = 1240;
  public static final short MSG_REQUEST_MAPAREA = 1250;
  public static final short MSG_RESP_MAPAREA = 1251;
  public static final short MSG_REQUEST_SMALLMAP = 1252;
  public static final short MSG_RESP_SMALLMAP = 1253;
  public static final short MSG_REQUEST_GALAXYMAPAREA = 1254;
  public static final short MSG_REQUEST_MAPBLOCK = 1255;
  public static final short MSG_RESP_MAPBLOCKFIGHT = 1256;
  public static final short MSG_REQUEST_MAPBLOCKUSERINFO = 1257;
  public static final short MSG_RESP_MAPBLOCKUSERINFO = 1258;
  public static final short MSG_REQUEST_CREATESHIPMODEL = 1300;
  public static final short MSG_RESP_CREATESHIPMODEL = 1301;
  public static final short MSG_REQUEST_SHIPMODELINFO = 1302;
  public static final short MSG_RESP_SHIPMODELINFO = 1303;
  public static final short MSG_RESP_SHIPMODELINFODEL = 1304;
  public static final short MSG_REQUEST_DELETESHIPMODEL = 1305;
  public static final short MSG_RESP_DELETESHIPMODEL = 1306;
  public static final short MSG_REQUEST_SHIPBODYINFO = 1307;
  public static final short MSG_RESP_SHIPBODYINFO = 1308;
  public static final short MSG_REQUEST_CREATESHIP = 1309;
  public static final short MSG_RESP_CREATESHIP = 1310;
  public static final short MSG_REQUEST_CANCELSHIP = 1311;
  public static final short MSG_RESP_CANCELSHIP = 1312;
  public static final short MSG_REQUEST_CREATESHIPINFO = 1313;
  public static final short MSG_RESP_CREATESHIPINFO = 1314;
  public static final short MSG_RESP_SHIPCREATINGCOMPLETE = 1315;
  public static final short MSG_REQUEST_CREATESHIPTEAM = 1316;
  public static final short MSG_RESP_CREATESHIPTEAM = 1317;
  public static final short MSG_REQUEST_ARRANGESHIPTEAM = 1318;
  public static final short MSG_RESP_ARRANGESHIPTEAM = 1319;
  public static final short MSG_REQUEST_EDITSHIPTEAM = 1320;
  public static final short MSG_RESP_EDITSHIPTEAM = 1321;
  public static final short MSG_REQUEST_MOVESHIPTEAM = 1322;
  public static final short MSG_RESP_MOVESHIPTEAM = 1323;
  public static final short MSG_REQUEST_DELETESHIPTEAM = 1324;
  public static final short MSG_RESP_DELETESHIPTEAM = 1325;
  public static final short MSG_REQUEST_DISBANDSHIPTEAM = 1326;
  public static final short MSG_RESP_DISBANDSHIPTEAM = 1327;
  public static final short MSG_REQUEST_LOADSHIPTEAM = 1328;
  public static final short MSG_RESP_LOADSHIPTEAM = 1329;
  public static final short MSG_REQUEST_LOADINFOSHIPTEAM = 1330;
  public static final short MSG_RESP_LOADINFOSHIPTEAM = 1331;
  public static final short MSG_REQUEST_UNLOADSHIPTEAM = 1332;
  public static final short MSG_RESP_UNLOADSHIPTEAM = 1333;
  public static final short MSG_REQUEST_UNITESHIPTEAM = 1334;
  public static final short MSG_RESP_UNITESHIPTEAM = 1335;
  public static final short MSG_RESP_GALAXYSHIP = 1336;
  public static final short MSG_RESP_CREATESHIPBROADCAST = 1337;
  public static final short MSG_REQUEST_DIRECTIONSHIPTEAM = 1338;
  public static final short MSG_RESP_DIRECTIONSHIPTEAM = 1339;
  public static final short MSG_SHIPTEAMHOLDGALAXY = 1340;
  public static final short MSG_RESP_DELSHIPTEAMBROADCAST = 1341;
  public static final short MSG_REQUEST_TARGETSHIPTEAM = 1342;
  public static final short MSG_RESP_TARGETSHIPTEAM = 1343;
  public static final short MSG_REQUEST_SPEEDSHIPBODYUPGRADE = 1344;
  public static final short MSG_RESP_SPEEDSHIPBODYUPGRADE = 1345;
  public static final short MSG_REQUEST_FROMRESOURCESTARTOHOME = 1346;
  public static final short MSG_RESP_FROMRESOURCESTARTOHOME = 1347;
  public static final short MSG_RESP_SHIPTEAMTRADE = 1348;
  public static final short MSG_REQUEST_SHIPTEAMTRADEGOODS = 1349;
  public static final short MSG_RESP_SHIPTEAMTRADEGOODS = 1350;
  public static final short MSG_REQUEST_LOADSHIPTEAMALL = 1351;
  public static final short MSG_RESP_LOADSHIPTEAMALL = 1352;
  public static final short MSG_RESP_SHIPTEAMTRADECOMPLETE = 1353;
  public static final short MSG_REQUEST_UNITESHIPTEAM_RES = 1354;
  public static final short MSG_REQUEST_SHIPBODYUPGRADE = 1355;
  public static final short MSG_RESP_SHIPBODYUPGRADE = 1356;
  public static final short MSG_REQUEST_JUMPGALAXYSHIP = 1357;
  public static final short MSG_RESP_JUMPGALAXYSHIP = 1358;
  public static final short MSG_REQUEST_GOTORESOURCESTAR = 1359;
  public static final short MSG_RESP_GOTORESOURCESTAR = 1360;
  public static final short MSG_REQUEST_SHIPTEAMGOHOME = 1361;
  public static final short MSG_REQUEST_BUYSHIPINFO = 1362;
  public static final short MSG_RESP_BUYSHIPINFO = 1363;
  public static final short MSG_REQUEST_DESTROYSHIP = 1364;
  public static final short MSG_RESP_DESTROYSHIP = 1365;
  public static final short MSG_REQUEST_SPEEDSHIP = 1366;
  public static final short MSG_RESP_SPEEDSHIP = 1367;
  public static final short MSG_REQUEST_SHIPBODYUPGRADEINFO = 1368;
  public static final short MSG_RESP_SHIPBODYUPGRADEINFO = 1369;
  public static final short MSG_RESP_SHIPBODYUPGRADECOMPLETE = 1370;
  public static final short MSG_REQUEST_SHIPTEAMINFO = 1371;
  public static final short MSG_RESP_SHIPTEAMINFO = 1372;
  public static final short MSG_REQUEST_CREATETEAMMODEL = 1373;
  public static final short MSG_RESP_TEAMMODELINFO = 1374;
  public static final short MSG_REQUEST_ADDSHIPMODELDEL = 1375;
  public static final short MSG_REQUEST_UNIONFLAGSHIP = 1376;
  public static final short MSG_RESP_UNIONFLAGSHIP = 1377;
  public static final short MSG_REQUEST_UPGRADEFLAGSHIP = 1378;
  public static final short MSG_RESP_UPGRADEFLAGSHIP = 1379;
  public static final short MSG_REQUEST_UNIONSHIPPROPS = 1380;
  public static final short MSG_RESP_UNIONSHIPPROPS = 1381;
  public static final short MSG_REQUEST_UPGRADESHIPPROPS = 1382;
  public static final short MSG_RESP_UPGRADESHIPPROPS = 1383;
  public static final short MSG_REQUEST_JUMPSHIPTEAM = 1400;
  public static final short MSG_RESP_JUMPSHIPTEAM = 1401;
  public static final short MSG_REQUEST_JUMPSHIPTEAMINFO = 1402;
  public static final short MSG_RESP_JUMPSHIPTEAMINFO = 1403;
  public static final short MSG_RESP_JUMPSHIPTEAMCOMPLETE = 1404;
  public static final short MSG_REQUEST_JUMPSHIPTEAMCHANGE = 1405;
  public static final short MSG_RESP_JUMPSHIPTEAMCHANGE = 1406;
  public static final short MSG_REQUEST_VIEWJUMPSHIPTEAM = 1407;
  public static final short MSG_RESP_VIEWJUMPSHIPTEAM = 1408;
  public static final short MSG_REQUEST_CREATEFIGHT = 1409;
  public static final short MSG_RESP_FIGHTSECTION = 1410;
  public static final short MSG_RESP_GALAXYFIGHTBEG = 1411;
  public static final short MSG_RESP_GALAXYFIGHTEND = 1412;
  public static final short MSG_RESP_FIGHTBOUTBEG = 1413;
  public static final short MSG_RESP_FIGHTBOUTEND = 1414;
  public static final short MSG_RESP_FIGHTRESULT = 1415;
  public static final short MSG_RESP_FIGHTINIT_SHIPTEAM = 1416;
  public static final short MSG_RESP_FIGHTINIT_BUILD = 1417;
  public static final short MSG_REQUEST_BRUISESHIPINFO = 1418;
  public static final short MSG_RESP_BRUISESHIPINFO = 1419;
  public static final short MSG_REQUEST_SPEEDBRUISESHIP = 1420;
  public static final short MSG_RESP_SPEEDBRUISESHIP = 1421;
  public static final short MSG_REQUEST_BRUISESHIPRELIVE = 1422;
  public static final short MSG_RESP_BRUISESHIPRELIVE = 1423;
  public static final short MSG_REQUEST_BRUISESHIPDELETE = 1424;
  public static final short MSG_RESP_BRUISESHIPDELETE = 1425;
  public static final short MSG_REQUEST_WARINVITE = 1426;
  public static final short MSG_RESP_WARINVITE = 1427;
  public static final short MSG_RESP_PKINVITE = 1428;
  public static final short MSG_REQUEST_WARSTATE = 1429;
  public static final short MSG_RESP_WARSTATE = 1430;
  public static final short MSG_REQUEST_WARACCEPT = 1431;
  public static final short MSG_RESP_WARACCEPT = 1432;
  public static final short MSG_RESP_WARRESULT = 1433;
  public static final short MSG_REQUEST_WARMSGSTOP = 1434;
  public static final short MSG_RESP_WARMSGSTOP = 1435;
  public static final short MSG_RESP_ECTYPEPASS = 1436;
  public static final short MSG_REQUEST_ECTYPEINFO = 1437;
  public static final short MSG_REQUEST_CANCELJUMPSHIPTEAM = 1438;
  public static final short MSG_RESP_CANCELJUMPSHIPTEAM = 1439;
  public static final short MSG_REQUEST_FLIGHTSHIPTEAM = 1440;
  public static final short MSG_RESP_FLIGHTSHIPTEAM = 1441;
  public static final short MSG_REQUEST_FLIGHTSHIPTEAMOVER = 1442;
  public static final short MSG_RESP_FLIGHTSHIPTEAMOVER = 1443;
  public static final short MSG_RESP_FIGHTFORTRESSSECTION = 1444;
  public static final short MSG_RESP_JUMPSHIPTEAMNOTICE = 1445;
  public static final short MSG_REQUEST_MATCHINFO = 1446;
  public static final short MSG_RESP_MATCHINFO = 1447;
  public static final short MSG_REQUEST_MATCHPAGE = 1448;
  public static final short MSG_RESP_MATCHPAGE = 1449;
  public static final short MSG_REQUEST_CREATECOMMANDER = 1500;
  public static final short MSG_RESP_CREATECOMMANDER = 1501;
  public static final short MSG_REQUEST_UPDATENAMECOMMANDER = 1502;
  public static final short MSG_RESP_UPDATENAMECOMMANDER = 1503;
  public static final short MSG_REQUEST_DELETECOMMANDER = 1504;
  public static final short MSG_RESP_DELETECOMMANDER = 1505;
  public static final short MSG_REQUEST_COMMANDERINFO = 1506;
  public static final short MSG_RESP_COMMANDERINFO = 1507;
  public static final short MSG_REQUEST_RELIVECOMMANDER = 1508;
  public static final short MSG_RESP_RELIVECOMMANDER = 1509;
  public static final short MSG_REQUEST_RESUMECOMMANDER = 1510;
  public static final short MSG_RESP_RESUMECOMMANDER = 1511;
  public static final short MSG_REQUEST_CLEARCOMMANDERPERCENT = 1512;
  public static final short MSG_RESP_CLEARCOMMANDERPERCENT = 1513;
  public static final short MSG_RESP_COMMANDERBASEINFO = 1514;
  public static final short MSG_REQUEST_COMMANDERINFOARRANGE = 1515;
  public static final short MSG_RESP_COMMANDERINFOARRANGE = 1516;
  public static final short MSG_REQUEST_COMMANDEREDITSHIPTEAM = 1517;
  public static final short MSG_RESP_COMMANDEREDITSHIPTEAM = 1518;
  public static final short MSG_RESP_COMMANDERCARD = 1519;
  public static final short MSG_REQUEST_GETSECONDCOMMANDERCARD = 1520;
  public static final short MSG_RESP_GETSECONDCOMMANDERCARD = 1521;
  public static final short MSG_REQUEST_UNIONCOMMANDERCARD = 1522;
  public static final short MSG_RESP_UNIONCOMMANDERCARD = 1523;
  public static final short MSG_REQUEST_COMMANDERCHANGECARD = 1524;
  public static final short MSG_RESP_COMMANDERCHANGECARD = 1525;
  public static final short MSG_RESP_UNIONCOMMANDERCARDBRO = 1526;
  public static final short MSG_RESP_REFRESHCOMMANDERBASEINFO = 1527;
  public static final short MSG_REQUEST_COMMANDERINSERTSTONE = 1528;
  public static final short MSG_RESP_COMMANDERINSERTSTONE = 1529;
  public static final short MSG_REQUEST_COMMANDERUNIONSTONE = 1530;
  public static final short MSG_RESP_COMMANDERUNIONSTONE = 1531;
  public static final short MSG_REQUEST_COMMANDERSTONEINFO = 1532;
  public static final short MSG_RESP_COMMANDERSTONEINFO = 1533;
  public static final short MSG_RESP_COMMANDERCARDBRO = 1534;
  public static final short MSG_REQUEST_UNIONDOUBLESKILLCARD = 1535;
  public static final short MSG_RESP_UNIONDOUBLESKILLCARD = 1536;
  public static final short MSG_REQUEST_UNBINDCOMMANDERCARD = 1537;
  public static final short MSG_RESP_UNBINDCOMMANDERCARD = 1538;
  public static final short MSG_REQUEST_COMMANDERINSERTCMOS = 1539;
  public static final short MSG_RESP_COMMANDERINSERTCMOS = 1540;
  public static final short MSG_REQUEST_COMMANDERPROPERTYSTONE = 1541;
  public static final short MSG_RESP_COMMANDERPROPERTYSTONE = 1542;
  public static final short MSG_REQUEST_CONSORTIAINFO = 1550;
  public static final short MSG_RESP_CONSORTIAINFO = 1551;
  public static final short MSG_REQUEST_CONSORTIAPROCLAIM = 1552;
  public static final short MSG_RESP_CONSORTIAPROCLAIM = 1553;
  public static final short MSG_REQUEST_CREATECONSORTIA = 1554;
  public static final short MSG_RESP_CREATECONSORTIA = 1555;
  public static final short MSG_REQUEST_CONSORTIAMYSELF = 1556;
  public static final short MSG_RESP_CONSORTIAMYSELF = 1557;
  public static final short MSG_REQUEST_CONSORTIAMEMBER = 1558;
  public static final short MSG_RESP_CONSORTIAMEMBER = 1559;
  public static final short MSG_REQUEST_EDITCONSORTIA = 1560;
  public static final short MSG_RESP_EDITCONSORTIA = 1561;
  public static final short MSG_REQUEST_CONSORTIATHROWVALUE = 1562;
  public static final short MSG_RESP_CONSORTIATHROWVALUE = 1563;
  public static final short MSG_REQUEST_CONSORTIADELMEMBER = 1564;
  public static final short MSG_RESP_CONSORTIADELMEMBER = 1565;
  public static final short MSG_REQUEST_JOINCONSORTIA = 1566;
  public static final short MSG_RESP_JOINCONSORTIA = 1567;
  public static final short MSG_RESP_OPERATECONSORTIABRO = 1568;
  public static final short MSG_RESP_CONSORTIADELMEMBERBRO = 1569;
  public static final short MSG_REQUEST_CONSORTIASETOFFICIAL = 1570;
  public static final short MSG_RESP_CONSORTIASETOFFICIAL = 1571;
  public static final short MSG_REQUEST_CONSORTIAGIVEN = 1572;
  public static final short MSG_RESP_CONSORTIAGIVEN = 1573;
  public static final short MSG_REQUEST_CONSORTIAAUTHUSER = 1574;
  public static final short MSG_RESP_CONSORTIAAUTHUSER = 1575;
  public static final short MSG_REQUEST_DEALCONSORTIAAUTHUSER = 1576;
  public static final short MSG_RESP_CONSORTIASTAR = 1577;
  public static final short MSG_REQUEST_CONSORTIATHROWRANK = 1578;
  public static final short MSG_RESP_CONSORTIATHROWRANK = 1579;
  public static final short MSG_REQUEST_CONSORTIAFIELD = 1580;
  public static final short MSG_RESP_CONSORTIAFIELD = 1581;
  public static final short MSG_RESP_CONSORTIAWEALTH = 1582;
  public static final short MSG_REQUEST_CONSORTIAUPGRADE = 1583;
  public static final short MSG_RESP_CONSORTIAUPGRADE = 1584;
  public static final short MSG_REQUEST_CONSORTIARANK = 1585;
  public static final short MSG_RESP_CONSORTIARANK = 1586;
  public static final short MSG_RESP_DEALCONSORTIAAUTHUSER = 1587;
  public static final short MSG_REQUEST_CONSORTIAATTACKINFO = 1588;
  public static final short MSG_RESP_CONSORTIAATTACKINFO = 1589;
  public static final short MSG_REQUEST_CONSORTIAUPDATEJOBNAME = 1590;
  public static final short MSG_REQUEST_CONSORTIAUPDATAVALUE = 1591;
  public static final short MSG_RESP_CONSORTIAUPDATAVALUE = 1592;
  public static final short MSG_REQUEST_CONSORTIABUYGOODS = 1593;
  public static final short MSG_RESP_CONSORTIABUYGOODS = 1594;
  public static final short MSG_RESP_CONSORTIAUPGRADECOMPLETE = 1595;
  public static final short MSG_REQUEST_CONSORTIAUPGRADECANCEL = 1596;
  public static final short MSG_RESP_CONSORTIAUPGRADECANCEL = 1597;
  public static final short MSG_REQUEST_CONSORTIAEVENT = 1598;
  public static final short MSG_RESP_CONSORTIAEVENT = 1599;
  public static final short MSG_CHAT_MESSAGE = 1600;
  public static final short MSG_REQUEST_ADDFRIEND = 1601;
  public static final short MSG_RESP_ADDFRIEND = 1602;
  public static final short MSG_REQUEST_DELFRIEND = 1603;
  public static final short MSG_RESP_DELFRIEND = 1604;
  public static final short MSG_REQUEST_FRIENDLIST = 1605;
  public static final short MSG_RESP_FRIENDLIST = 1606;
  public static final short MSG_REQUEST_SENDEMAIL = 1607;
  public static final short MSG_REQUEST_EMAILINFO = 1608;
  public static final short MSG_RESP_EMAILINFO = 1609;
  public static final short MSG_REQUEST_DELETEEMAIL = 1610;
  public static final short MSG_REQUEST_READEMAIL = 1611;
  public static final short MSG_RESP_READEMAIL = 1612;
  public static final short MSG_REQUEST_EMAILGOODS = 1613;
  public static final short MSG_RESP_EMAILGOODS = 1614;
  public static final short MSG_REQUEST_FRIENDINFO = 1615;
  public static final short MSG_RESP_FRIENDINFO = 1616;
  public static final short MSG_REQUEST_FRIENDLEVEL = 1617;
  public static final short MSG_RESP_FRIENDLEVEL = 1618;
  public static final short MSG_RESP_ADDFRIENDAUTH = 1619;
  public static final short MSG_REQUEST_FRIENDPASSAUTH = 1620;
  public static final short MSG_RESP_FRIENDPASSAUTH = 1621;
  public static final short MSG_RESP_NEWEMAILNOTICE = 1622;
  public static final short MSG_REQUEST_USERINFO = 1623;
  public static final short MSG_RESP_USERINFO = 1624;
  public static final short MSG_REQUEST_LOOKUPUSERINFO = 1625;
  public static final short MSG_RESP_LOOKUPUSERINFO = 1626;
  public static final short MSG_REQUEST_INSERTFLAGCONSORTIAIMEMBER = 1650;
  public static final short MSG_RESP_INSERTFLAGCONSORTIAIMEMBER = 1651;
  public static final short MSG_REQUEST_CONSORTIAPIRATE = 1652;
  public static final short MSG_RESP_CONSORTIAPIRATE = 1653;
  public static final short MSG_REQUEST_CONSORTIAPIRATECHOOSE = 1654;
  public static final short MSG_RESP_CONSORTIAPIRATECHOOSE = 1655;
  public static final short MSG_RESP_CONSORTIAPIRATEBRO = 1656;
  public static final short MSG_REQUEST_CONSORTIAINFO2 = 1657;
  public static final short MSG_REQUEST_RANKCENT = 1700;
  public static final short MSG_RESP_RANKCENT = 1701;
  public static final short MSG_REQUEST_RANKKILLTOTAL = 1702;
  public static final short MSG_RESP_RANKKILLTOTAL = 1703;
  public static final short MSG_REQUEST_RANKFIGHT = 1704;
  public static final short MSG_RESP_RANKFIGHT = 1705;
  public static final short MSG_REQUEST_RANKMATCH = 1706;
  public static final short MSG_RESP_RANKMATCH = 1707;
  public static final short MSG_REQUEST_TRADEGOODS = 1750;
  public static final short MSG_RESP_TRADEGOODS = 1751;
  public static final short MSG_REQUEST_MYTRADEINFO = 1752;
  public static final short MSG_RESP_MYTRADEINFO = 1753;
  public static final short MSG_REQUEST_DELETETRADEGOODS = 1754;
  public static final short MSG_RESP_DELETETRADEGOODS = 1755;
  public static final short MSG_REQUEST_TRADEINFO = 1756;
  public static final short MSG_RESP_TRADEINFO = 1757;
  public static final short MSG_REQUEST_BUYTRADEGOODS = 1758;
  public static final short MSG_RESP_BUYTRADEGOODS = 1759;
  public static final short MSG_REQUEST_FIELDRESOURCE = 1800;
  public static final short MSG_RESP_FIELDRESOURCE = 1801;
  public static final short MSG_REQUEST_GROWFIELDRESOURCE = 1802;
  public static final short MSG_RESP_GROWFIELDRESOURCE = 1803;
  public static final short MSG_REQUEST_GETFIELDRESOURCE = 1804;
  public static final short MSG_RESP_GETFIELDRESOURCE = 1805;
  public static final short MSG_REQUEST_THIEVEFIELDRESOURCE = 1806;
  public static final short MSG_RESP_THIEVEFIELDRESOURCE = 1807;
  public static final short MSG_REQUEST_DELETEFIELDRESOURCE = 1808;
  public static final short MSG_RESP_DELETEFIELDRESOURCE = 1809;
  public static final short MSG_REQUEST_FIELDRESOURCELOG = 1810;
  public static final short MSG_RESP_FIELDRESOURCELOG = 1811;
  public static final short MSG_REQUEST_HELPFIELDCENTERRESOURCE = 1812;
  public static final short MSG_RESP_HELPFIELDCENTERRESOURCE = 1813;
  public static final short MSG_REQUEST_FRIENDFIELDSTATUS = 1814;
  public static final short MSG_RESP_FRIENDFIELDSTATUS = 1815;
  public static final short MSG_REQUEST_GAINCMOSLOTTERY = 1900;
  public static final short MSG_RESP_GAINCMOSLOTTERY = 1901;
  public static final short MSG_REQUEST_CMOSLOTTERYINFO = 1902;
  public static final short MSG_RESP_CMOSLOTTERYINFO = 1903;
  public static final short MSG_REQUEST_UNIONCMOS = 1904;
  public static final short MSG_RESP_UNIONCMOS = 1905;
  public static final short MSG_REQUEST_OPENCMOSPACK = 1906;
  public static final short MSG_RESP_OPENCMOSPACK = 1907;
  public static final short MSG_REQUEST_SELLPROPS = 1908;
  public static final short MSG_RESP_SELLPROPS = 1909;
  public static final short MSG_RESP_PAYMENTSUCCEED = 1910;
  public static final short MSG_RESP_PASS_TOLLGATE = 1136;
  public static final short MSG_REQUEST_ARENA_STATUS = 1450;
  public static final short MSG_RESP_ARENA_STATUS = 1451;
  public static final short MSG_REQUEST_ARENA_PAGE = 1452;
  public static final short MSG_RESP_ARENA_PAGE = 1453;
  public static final short MSG_RESP_CAPTURE_ARK_INFO = 1454;
  public static final short MSG_RESP_CAPTURE_ARK_LIST = 1455;
  public static final short MSG_RESP_CAPTURE_ARK_ROOM = 1456;
  public static final short MSG_REQUEST_CAPTURE_STATE = 1457;
  public static final short MSG_RESP_DUPLICATE_BATTLE = 1458;
  public static final short MSG_RESP_CAPTURE_BULLETIN = 1459;
  public static final short MSG_REQUEST_WARFIELD_STATUS = 1460;
  public static final short MSG_RESP_WARFIELD_STATUS = 1461;
  public static final short MSG_RESP_DUPLICATE_BULLETIN = 1462;
  public static final short MSG_RESP_WARFIELD_PAGE = 1463;
  public static final short MSG_RESP_WARFIELD_PLAYERLIST = 1464;
  public static final short MSG_DUPLICATE_STATUS = 1465;
  public static final short MSG_REQUEST_RACINGINFO = 1850;
  public static final short MSG_RESP_RACINGINFO = 1851;
  public static final short MSG_REQUEST_RACINGBATTLE = 1852;
  public static final short MSG_RESP_RACINGBATTLE = 1853;
  public static final short MSG_REQUEST_RACINGAWARD = 1854;
  public static final short MSG_RESP_RACINGAWARD = 1855;
  public static final short MSG_REQUEST_JOINRACING = 1856;
  public static final short MSG_REQUEST_RACINGCREATEROLE = 1857;
  public static final short MSG_REQUEST_RACINGBATTLEEND = 1858;
  public static final short MSG_REQUEST_RACINGBATTLEDATA = 1859;
  public static final short MSG_REQUEST_SETRACINGSHIPTEAM = 1860;
  public static final short MSG_RESP_SETRACINGSHIPTEAM = 1861;
  public static final short MSG_RESP_RACINGSHIPMODEL = 1862;
  public static final short MSG_RESP_RACINGCOMMANDER = 1863;
  public static final short MSG_RESP_RACINGSHIPTEAM = 1864;
  public static final short MSG_RESP_RACINGINFOSHIPTEAM = 1865;
  public static final short MSG_RESP_RACINGTECH = 1866;
  public static final short MSG_REQUEST_RACINGRANK = 1867;
  public static final short MSG_RESP_RACINGRANK = 1868;
  
  public MsgTypes() {
    super();
  }
  
  /**
   * Gets the <code>MsgTypes</code> instance and creates one if it doesn't exist.
   * @return The MsgTypes object
   */
  public static MsgTypes instance() {
    if(instance == null) {
      instance = new MsgTypes();
    }
    return instance;
  }
}
