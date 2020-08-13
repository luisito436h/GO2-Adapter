package net.skimnerphi.go2.util;

import com.igg.go2.common.MsgHead;
import com.igg.go2.common.MsgTypes;
import com.igg.go2.msg.*;
import com.igg.go2.msg.chat.*;
import com.igg.go2.msg.chiplottery.*;
import com.igg.go2.msg.commander.*;
import com.igg.go2.msg.compose.*;
import com.igg.go2.msg.construction.*;
import com.igg.go2.msg.corps.*;
import com.igg.go2.msg.destructionship.*;
import com.igg.go2.msg.facebook.*;
import com.igg.go2.msg.field.*;
import com.igg.go2.msg.fight.*;
import com.igg.go2.msg.flagship.*;
import com.igg.go2.msg.fleet.*;
import com.igg.go2.msg.friend.*;
import com.igg.go2.msg.galaxymap.*;
import com.igg.go2.msg.gymkhana.*;
import com.igg.go2.msg.instance.*;
import com.igg.go2.msg.loadhe3.*;
import com.igg.go2.msg.mail.*;
import com.igg.go2.msg.mall.*;
import com.igg.go2.msg.match.*;
import com.igg.go2.msg.minimap.*;
import com.igg.go2.msg.radar.*;
import com.igg.go2.msg.raidprops.*;
import com.igg.go2.msg.rank.*;
import com.igg.go2.msg.reward.*;
import com.igg.go2.msg.sciencesystem.*;
import com.igg.go2.msg.ship.*;
import com.igg.go2.msg.shipmodel.*;
import com.igg.go2.msg.task.*;
import com.igg.go2.msg.upgrade.*;

/**
 * Accepts arrays of raw bytes and parses them into valid MsgHead subclasses
 * @author SkimnerPhi
 */
public class MessageFactory {
  public MsgHead getMessage(byte[] b, int msgType) {
    MsgHead msg = null;
    
    //Gross
    switch(msgType) {
      case MsgTypes.MSG_RESP_WARFIELD_STATUS:
        msg = new MsgRespWarFieldStatus();
        break;
      case MsgTypes.MSG_RESP_DUPLICATE_BULLETIN:
        msg = new MsgRespDuplicateBulletin();
        break;
      case MsgTypes.MSG_RESP_WARFIELD_PLAYERLIST:
        msg = new MsgRespWarFieldPlayerList();
        break;
      case MsgTypes.MSG_RESP_GAMESERVERLIST:
        msg = new MsgRespGameServerList();
        break;
      case MsgTypes.MSG_RESP_CHANGESERVER:
        msg = new MsgRespChangeServer();
        break;
      case MsgTypes.MSG_RESP_DELETESERVER:
        msg = new MsgRespDeleteServer();
        break;
      case MsgTypes.MSG_CHAT_MESSAGE:
        msg = new MsgChatMessage();
        break;
      case MsgTypes.MSG_RESP_USERINFO:
        msg = new MsgRespUserInfo();
        break;
      case MsgTypes.MSG_RESP_GALAXYBROADCAST:
        msg = new MsgRespGalaxyBroadcast();
        break;
      case MsgTypes.MSG_RESP_CMOSLOTTERYINFO:
        msg = new MsgRespCmosLotteryInfo();
        break;
      case MsgTypes.MSG_RESP_GAINCMOSLOTTERY:
        msg = new MsgRespGainCmosLottery();
        break;
      case MsgTypes.MSG_RESP_COMMANDERBASEINFO:
        msg = new MsgRespCommanderBaseInfo();
        break;
      case MsgTypes.MSG_RESP_COMMANDERINFO:
        msg = new MsgRespCommanderInfo();
        break;
      case MsgTypes.MSG_RESP_CREATECOMMANDER:
        msg = new MsgRespCreateCommander();
        break;
      case MsgTypes.MSG_RESP_COMMANDERCARD:
        msg = new MsgRespCommanderCard();
        break;
      case MsgTypes.MSG_RESP_COMMANDEREDITSHIPTEAM:
        msg = new MsgRespCommanderEditShipTeam();
        break;
      case MsgTypes.MSG_RESP_DELETECOMMANDER:
        msg = new MsgRespDeleteCommander();
        break;
      case MsgTypes.MSG_RESP_RELIVECOMMANDER:
        msg = new MsgRespReliveCommander();
        break;
      case MsgTypes.MSG_RESP_RESUMECOMMANDER:
        msg = new MsgRespResumeCommander();
        break;
      case MsgTypes.MSG_RESP_CLEARCOMMANDERPERCENT:
        msg = new MsgRespClearCommanderPercent();
        break;
      case MsgTypes.MSG_RESP_COMMANDERCHANGECARD:
        msg = new MsgRespCommanderChangeCard();
        break;
      case MsgTypes.MSG_RESP_REFRESHCOMMANDERBASEINFO:
        msg = new MsgRespRefreshCommanderBaseInfo();
        break;
      case MsgTypes.MSG_RESP_COMMANDERSTONEINFO:
        msg = new MsgRespCommanderStoneInfo();
        break;
      case MsgTypes.MSG_RESP_UNIONCOMMANDERCARD:
        msg = new MsgRespUnionCommanderCard();
        break;
      case MsgTypes.MSG_RESP_UNIONDOUBLESKILLCARD:
        msg = new MsgRespUnionDoubleSkillCard();
        break;
      case MsgTypes.MSG_RESP_UNIONCOMMANDERCARDBRO:
        msg = new MsgRespUnionCommanderCardBro();
        break;
      case MsgTypes.MSG_RESP_COMMANDERCARDBRO:
        msg = new MsgRespCommanderCardBro();
        break;
      case MsgTypes.MSG_RESP_COMMANDERUNIONSTONE:
        msg = new MsgRespCommanderUnionStone();
        break;
      case MsgTypes.MSG_RESP_COMMANDERINSERTSTONE:
        msg = new MsgRespCommanderInsertStone();
        break;
      case MsgTypes.MSG_RESP_REFRESHWALL:
        msg = new MsgRespRefreshWall();
        break;
      case MsgTypes.MSG_RESP_COMMANDERPROPERTYSTONE:
        msg = new MsgRespCommanderPropertyStone();
        break;
      case MsgTypes.MSG_RESP_UNIONFLAGSHIP:
        msg = new MsgRespUnionFlagship();
        break;
      case MsgTypes.MSG_RESP_UNIONSHIPPROPS:
        msg = new MsgRespUnionShipProps();
        break;
      case MsgTypes.MSG_RESP_COMMANDERINSERTCMOS:
        msg = new MsgRespCommanderInsertCmos();
        break;
      case MsgTypes.MSG_RESP_BUILDINFO:
        msg = new MsgRespBuildInfo();
        break;
      case MsgTypes.MSG_RESP_CREATEBUILD:
        msg = new MsgRespCreateBuild();
        break;
      case MsgTypes.MSG_RESP_BUILDCOMPLETE:
        msg = new MsgRespBuildComplete();
        break;
      case MsgTypes.MSG_RESP_CANCELBUILD:
        msg = new MsgRespCancelBuild();
        break;
      case MsgTypes.MSG_RESP_DELETEBUILD:
        msg = new MsgRespDeleteBuild();
        break;
      case MsgTypes.MSG_RESP_MOVEBUILD:
        msg = new MsgRespMoveBuild();
        break;
      case MsgTypes.MSG_RESP_STORAGERESOURCE:
        msg = new MsgRespStorageResource();
        break;
      case MsgTypes.MSG_RESP_GETSTORAGERESOURCE:
        msg = new MsgRespGetStorageResource();
        break;
      case MsgTypes.MSG_RESP_BUILDINGDEATHCOMPLETE:
        msg = new MsgRespBuildingDeathComplete();
        break;
      case MsgTypes.MSG_RESP_SPEEDBUILDING:
        msg = new MsgRespSpeedBuilding();
        break;
      case MsgTypes.MSG_RESP_TIMEQUEUE:
        msg = new MsgRespTimeQueue();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAWEALTH:
        msg = new MsgRespConsortiaWealth();
        break;
      case MsgTypes.MSG_RESP_CONSORTIABUILDING:
        msg = new MsgRespConsortiaBuilding();
        break;
      case MsgTypes.MSG_RESP_SPEEDFRIENDBUILDING:
        msg = new MsgRespSpeedFriendBuilding();
        break;
      case MsgTypes.MSG_RESP_CREATEBUILDINFO:
        msg = new MsgRespCreateBuildInfo();
        break;
      case MsgTypes.MSG_RESP_BUILDINFOFRIEND:
        msg = new MsgRespBuildInfoFriend();
        break;
      case MsgTypes.MSG_RESP_EXCHANGERES:
        msg = new MsgRespExchangeRes();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAINFO:
        msg = new MsgRespConsortiaInfo();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAPROCLAIM:
        msg = new MsgRespConsortiaProclaim();
        break;
      case MsgTypes.MSG_RESP_CREATECONSORTIA:
        msg = new MsgRespCreateConsortia();
        break;
      case MsgTypes.MSG_RESP_JOINCONSORTIA:
        msg = new MsgRespJoinConsortia();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAMYSELF:
        msg = new MsgRespConsortiaMyself();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAMEMBER:
        msg = new MsgRespConsortiaMember();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAAUTHUSER:
        msg = new MsgRespConsortiaAuthUser();
        break;
      case MsgTypes.MSG_RESP_OPERATECONSORTIABRO:
        msg = new MsgRespOperateConsortiaBro();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAFIELD:
        msg = new MsgRespConsortiaField();
        break;
      case MsgTypes.MSG_RESP_CONSORTIATHROWVALUE:
        msg = new MsgRespConsortiaThrowValue();
        break;
      case MsgTypes.MSG_RESP_CONSORTIATHROWRANK:
        msg = new MsgRespConsortiaThrowRank();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAGIVEN:
        msg = new MsgRespConsortiaGiven();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAUPGRADE:
        msg = new MsgRespConsortiaUpgrade();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAUPGRADECANCEL:
        msg = new MsgRespConsortiaUpgradeCancel();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAUPGRADECOMPLETE:
        msg = new MsgRespConsortiaUpgradeComplete();
        break;
      case MsgTypes.MSG_RESP_GOTORESOURCESTAR:
        msg = new MsgRespGoToResourceStar();
        break;
      case MsgTypes.MSG_RESP_DEALCONSORTIAAUTHUSER:
        msg = new MsgRespDealConsortiaAuthUser();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAATTACKINFO:
        msg = new MsgRespConsortiaAttackInfo();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAUPDATAVALUE:
        msg = new MsgRespConsortiaUpdateValue();
        break;
      case MsgTypes.MSG_RESP_CONSORTIABUYGOODS:
        msg = new MsgRespConsortiaBuyGoods();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAEVENT:
        msg = new MsgRespConsortiaEvent();
        break;
      case MsgTypes.MSG_RESP_INSERTFLAGCONSORTIAIMEMBER:
        msg = new MsgRespInsertFlagConsortiaMember();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAPIRATECHOOSE:
        msg = new MsgRespConsortiaPirateChoose();
        break;
      case MsgTypes.MSG_RESP_CONSORTIAPIRATEBRO:
        msg = new MsgRespConsortiaPirateBro();
        break;
      case MsgTypes.MSG_RESP_DESTROYSHIP:
        msg = new MsgRespDestroyShip();
        break;
      case MsgTypes.MSG_RESP_FRIENDINFO:
        msg = new MsgRespFriendInfo();
        break;
      case MsgTypes.MSG_RESP_FIELDRESOURCE:
        msg = new MsgRespFieldResource();
        break;
      case MsgTypes.MSG_RESP_GROWFIELDRESOURCE:
        msg = new MsgRespGrowFieldResource();
        break;
      case MsgTypes.MSG_RESP_GETFIELDRESOURCE:
        msg = new MsgRespGetFieldResource();
        break;
      case MsgTypes.MSG_RESP_THIEVEFIELDRESOURCE:
        msg = new MsgRespThieveFieldResource();
        break;
      case MsgTypes.MSG_RESP_FIELDRESOURCELOG:
        msg = new MsgRespFieldResourceLog();
        break;
      case MsgTypes.MSG_RESP_HELPFIELDCENTERRESOURCE:
        msg = new MsgRespHelpFieldCenterResource();
        break;
      case MsgTypes.MSG_RESP_FRIENDFIELDSTATUS:
        msg = new MsgRespFriendFieldStatus();
        break;
      case MsgTypes.MSG_RESP_ARRANGESHIPTEAM:
        msg = new MsgRespArrangeShipTeam();
        break;
      case MsgTypes.MSG_RESP_TEAMMODELINFO:
        msg = new MsgRespTeamModelInfo();
        break;
      case MsgTypes.MSG_RESP_EDITSHIPTEAM:
        msg = new MsgRespEditShipTeam();
        break;
      case MsgTypes.MSG_RESP_COMMANDERINFOARRANGE:
        msg = new MsgRespCommanderInfoArrange();
        break;
      case MsgTypes.MSG_RESP_FRIENDLIST:
        msg = new MsgRespFriendList();
        break;
      case MsgTypes.MSG_RESP_ADDFRIENDAUTH:
        msg = new MsgRespAddFriendAuth();
        break;
      case MsgTypes.MSG_RESP_FRIENDPASSAUTH:
        msg = new MsgRespFriendPassAuth();
        break;
      case MsgTypes.MSG_RESP_ADDFRIEND:
        msg = new MsgRespAddFriend();
        break;
      case MsgTypes.MSG_RESP_MATCHINFO:
        msg = new MsgRespMatchInfo();
        break;
      case MsgTypes.MSG_RESP_MATCHPAGE:
        msg = new MsgRespMatchPage();
        break;
      case MsgTypes.MSG_GAMESERVER_LOGINRESP:
        msg = new MsgGameServerLoginResp();
        break;
      case MsgTypes.MSG_LOGINSERVER_VALIDATE:
        msg = new MsgLoginServerValidate();
        break;
      case MsgTypes.MSG_ROLE_INFO:
        msg = new MsgRoleInfo();
        break;
      case MsgTypes.MSG_LOGINSERVER_GAMESERVERLISTRESP:
        msg = new MsgLoginServerGameServerListResp();
        break;
      case MsgTypes.MSG_LOGINSERVER_CHECKREGISTERNAMERESP:
        msg = new MsgLoginServerCheckRegisterNameResp();
        break;
      case MsgTypes.MSG_RESP_PLAYERRESOURCE:
        msg = new MsgRespPlayerResource();
        break;
      case MsgTypes.MSG_RESP_UPDATEPLAYERNAME:
        msg = new MsgRespUpdatePlayerName();
        break;
      case MsgTypes.MSG_RESP_PAYMENTSUCCEED:
        msg = new MsgRespPaymentSucceed();
        break;
      case MsgTypes.MSG_RESP_LOOKUPUSERINFO:
        msg = new MsgRespLookupUserInfo();
        break;
      case MsgTypes.MSG_RESP_RACINGINFO:
        msg = new MsgRespRacingInfo();
        break;
      case MsgTypes.MSG_RESP_RACINGBATTLE:
        msg = new MsgRespRacingBattle();
        break;
      case MsgTypes.MSG_RESP_RACINGAWARD:
        msg = new MsgRespRacingAward();
        break;
      case MsgTypes.MSG_RESP_SETRACINGSHIPTEAM:
        msg = new MsgRespSetRacingShipTeam();
        break;
      case MsgTypes.MSG_RESP_RACINGINFOSHIPTEAM:
        msg = new MsgRespRacingInfoShipTeam();
        break;
      case MsgTypes.MSG_DUPLICATE_STATUS:
        msg = new MsgDuplicateStatus();
        break;
      case MsgTypes.MSG_RESP_RACINGRANK:
        msg = new MsgRespRacingRank();
        break;
      case MsgTypes.MSG_RESP_RANKMATCH:
        msg = new MsgRespRankMatch();
        break;
      case MsgTypes.MSG_RESP_LOADSHIPTEAM:
        msg = new MsgRespLoadShipTeam();
        break;
      case MsgTypes.MSG_RESP_UNLOADSHIPTEAM:
        msg = new MsgRespUnloadShipTeam();
        break;
      case MsgTypes.MSG_RESP_LOADSHIPTEAMALL:
        msg = new MsgRespLoadShipTeamAll();
        break;
      case MsgTypes.MSG_RESP_EMAILINFO:
        msg = new MsgRespEmailInfo();
        break;
      case MsgTypes.MSG_RESP_READEMAIL:
        msg = new MsgRespReadEmail();
        break;
      case MsgTypes.MSG_RESP_EMAILGOODS:
        msg = new MsgRespEmailGoods();
        break;
      case MsgTypes.MSG_RESP_NEWEMAILNOTICE:
        msg = new MsgRespNewEmailNotice();
        break;
      case MsgTypes.MSG_RESP_TRADEGOODS:
        msg = new MsgRespTradeGoods();
        break;
      case MsgTypes.MSG_RESP_MYTRADEINFO:
        msg = new MsgRespMyTradeInfo();
        break;
      case MsgTypes.MSG_RESP_TRADEINFO:
        msg = new MsgRespTradeInfo();
        break;
      case MsgTypes.MSG_RESP_BUYTRADEGOODS:
        msg = new MsgRespBuyTradeGoods();
        break;
      case MsgTypes.MSG_RESP_BUYGOODS:
        msg = new MsgRespBuyGoods();
        break;
      case MsgTypes.MSG_RESP_MAPAREA:
        msg = new MsgRespMapArea();
        break;
      case MsgTypes.MSG_RESP_INSERTFLAGBRO:
        msg = new MsgRespInsertFlagBro();
        break;
      case MsgTypes.MSG_RESP_GALAXYSHIP:
        msg = new MsgRespGalaxyShip();
        break;
      case MsgTypes.MSG_RESP_MOVESHIPTEAM:
        msg = new MsgRespMoveShipTeam();
        break;
      case MsgTypes.MSG_RESP_DIRECTIONSHIPTEAM:
        msg = new MsgRespDirectionShipTeam();
        break;
      case MsgTypes.MSG_RESP_CREATESHIPTEAM:
        msg = new MsgRespCreateShipTeam();
        break;
      case MsgTypes.MSG_RESP_DELSHIPTEAMBROADCAST:
        msg = new MsgRespDelShipTeamBroadcast();
        break;
      case MsgTypes.MSG_RESP_SHIPTEAMINFO:
        msg = new MsgRespShipTeamInfo();
        break;
      case MsgTypes.MSG_RESP_JUMPGALAXYSHIP:
        msg = new MsgRespJumpGalaxyShip();
        break;
      case MsgTypes.MSG_RESP_JUMPSHIPTEAM:
        msg = new MsgRespJumpShipTeam();
        break;
      case MsgTypes.MSG_RESP_JUMPSHIPTEAMINFO:
        msg = new MsgRespJumpShipTeamInfo();
        break;
      case MsgTypes.MSG_RESP_JUMPSHIPTEAMCOMPLETE:
        msg = new MsgRespJumpShipTeamComplete();
        break;
      case MsgTypes.MSG_RESP_FIGHTINIT_SHIPTEAM:
        msg = new MsgRespFightInitShipTeam();
        break;
      case MsgTypes.MSG_RESP_FIGHTBOUTBEG:
        msg = new MsgRespFightBoutBeg();
        break;
      case MsgTypes.MSG_RESP_FIGHTSECTION:
        msg = new MsgRespFightSection();
        break;
      case MsgTypes.MSG_RESP_FIGHTFORTRESSSECTION:
        msg = new MsgRespFortressSection();
        break;
      case MsgTypes.MSG_RESP_FIGHTRESULT:
        msg = new MsgRespFightResult();
        break;
      case MsgTypes.MSG_SHIPTEAMHOLDGALAXY:
        msg = new MsgShipTeamHoldGalaxy();
        break;
      case MsgTypes.MSG_RESP_FIGHTINIT_BUILD:
        msg = new MsgRespFightInitBuild();
        break;
      case MsgTypes.MSG_RESP_GALAXYINFO:
        msg = new MsgRespGalaxyInfo();
        break;
      case MsgTypes.MSG_RESP_MOVEHOME:
        msg = new MsgRespMoveHome();
        break;
      case MsgTypes.MSG_FIGHTGALAXYBEGIN:
        msg = new MsgFightGalaxyBegin();
        break;
      case MsgTypes.MSG_FIGHTGALAXYOVER:
        msg = new MsgFightGalaxyOver();
        break;
      case MsgTypes.MSG_RESP_CANCELJUMPSHIPTEAM:
        msg = new MsgRespCancelJumpShipTeam();
        break;
      case MsgTypes.MSG_RESP_VIEWJUMPSHIPTEAM:
        msg = new MsgRespViewJumpShipTeam();
        break;
      case MsgTypes.MSG_RESP_PASS_TOLLGATE:
        msg = new MsgRespPassTollGate();
        break;
      case MsgTypes.MSG_RESP_MOVEHOMEBRO:
        msg = new MsgRespMoveHomeBro();
        break;
      case MsgTypes.MSG_RESP_MAPBLOCK:
        msg = new MsgRespMapBlock();
        break;
      case MsgTypes.MSG_RESP_CONSORTIASTAR:
        msg = new MsgRespConsortiaStar();
        break;
      case MsgTypes.MSG_RESP_MAPBLOCKFIGHT:
        msg = new MsgRespMapBlockFight();
        break;
      case MsgTypes.MSG_RESP_MAPBLOCKUSERINFO:
        msg = new MsgRespMapBlockUserInfo();
        break;
      case MsgTypes.MSG_RESP_JUMPSHIPTEAMNOTICE:
        msg = new MsgRespJumpShipTeamNotice();
        break;
      case MsgTypes.MSG_RESP_CAPTURE_ARK_LIST:
        msg = new MsgRespCaptureArkList();
        break;
      case MsgTypes.MSG_RESP_CAPTURE_ARK_ROOM:
        msg = new MsgRespCaptureArkRoom();
        break;
      case MsgTypes.MSG_RESP_CAPTURE_ARK_INFO:
        msg = new MsgRespCaptureArkInfo();
        break;
      case MsgTypes.MSG_RESP_DUPLICATE_BATTLE:
        msg = new MsgRespDuplicateBattle();
        break;
      case MsgTypes.MSG_RESP_CAPTURE_BULLETIN:
        msg = new MsgRespCaptureBulletin();
        break;
      case MsgTypes.MSG_RESP_RANKCENT:
        msg = new MsgRespRankCent();
        break;
      case MsgTypes.MSG_RESP_RANKKILLTOTAL:
        msg = new MsgRespRankKillTotal();
        break;
      case MsgTypes.MSG_RESP_CONSORTIARANK:
        msg = new MsgRespConsortiaRank();
        break;
      case MsgTypes.MSG_RESP_RANKFIGHT:
        msg = new MsgRespRankFight();
        break;
      case MsgTypes.MSG_RESP_WARFIELD_PAGE:
        msg = new MsgRespWarFieldPage();
        break;
      case MsgTypes.MSG_RESP_ONLINEAWARD:
        msg = new MsgRespOnlineAward();
        break;
      case MsgTypes.MSG_RESP_GETONLINEAWARD:
        msg = new MsgRespGetOnlineAward();
        break;
      case MsgTypes.MSG_RESP_SHIPMODELINFO:
        msg = new MsgRespShipModelInfo();
        break;
      case MsgTypes.MSG_RESP_SHIPMODELINFODEL:
        msg = new MsgRespShipModelInfoDel();
        break;
      case MsgTypes.MSG_RESP_CREATESHIP:
        msg = new MsgRespCreateShip();
        break;
      case MsgTypes.MSG_RESP_CANCELSHIP:
        msg = new MsgRespCancelShip();
        break;
      case MsgTypes.MSG_RESP_CREATESHIPINFO:
        msg = new MsgRespCreateShipInfo();
        break;
      case MsgTypes.MSG_RESP_SHIPCREATINGCOMPLETE:
        msg = new MsgRespShipCreatingComplete();
        break;
      case MsgTypes.MSG_RESP_SPEEDSHIP:
        msg = new MsgRespSpeedShip();
        break;
      case MsgTypes.MSG_RESP_SHIPBODYINFO:
        msg = new MsgRespShipBodyInfo();
        break;
      case MsgTypes.MSG_RESP_CREATESHIPMODEL:
        msg = new MsgRespCreateShipModel();
        break;
      case MsgTypes.MSG_RESP_BRUISESHIPINFO:
        msg = new MsgRespBruiseShipInfo();
        break;
      case MsgTypes.MSG_RESP_SPEEDBRUISESHIP:
        msg = new MsgRespSpeedBruiseShip();
        break;
      case MsgTypes.MSG_RESP_BRUISESHIPRELIVE:
        msg = new MsgRespBruiseShipRelive();
        break;
      case MsgTypes.MSG_RESP_BRUISESHIPDELETE:
        msg = new MsgRespBruiseShipDelete();
        break;
      case MsgTypes.MSG_RESP_TASKINFO:
        msg = new MsgRespTaskInfo();
        break;
      case MsgTypes.MSG_RESP_TASKGAIN:
        msg = new MsgRespTaskGain();
        break;
      case MsgTypes.MSG_RESP_GAINDAILYAWARD:
        msg = new MsgRespGainDailyAward();
        break;
      case MsgTypes.MSG_RESP_SHIPBODYUPGRADE:
        msg = new MsgRespShipBodyUpgrade();
        break;
      case MsgTypes.MSG_RESP_SHIPBODYUPGRADEINFO:
        msg = new MsgRespShipBodyUpgradeInfo();
        break;
      case MsgTypes.MSG_RESP_SHIPBODYUPGRADECOMPLETE:
        msg = new MsgRespShipBodyUpgradeComplete();
        break;
      case MsgTypes.MSG_RESP_SPEEDSHIPBODYUPGRADE:
        msg = new MsgRespSpeedShipBodyUpgrade();
        break;
      case MsgTypes.MSG_RESP_UPGRADEFLAGSHIP:
        msg = new MsgRespUpgradeFlagship();
        break;
      case MsgTypes.MSG_RESP_UPGRADESHIPPROPS:
        msg = new MsgRespUpgradeShipProps();
        break;
      case MsgTypes.MSG_RESP_ADDPACK:
        msg = new MsgRespAddPack();
        break;
      case MsgTypes.MSG_RESP_CANCELTECH:
        msg = new MsgRespCancelTech();
        break;
      case MsgTypes.MSG_RESP_CREATETECH:
        msg = new MsgRespCreateTech();
        break;
      case MsgTypes.MSG_RESP_CREATETECHCOMPLETE:
        msg = new MsgRespCreateTechComplete();
        break;
      case MsgTypes.MSG_RESP_DELETEPROPS:
        msg = new MsgRespDeleteProps();
        break;
      case MsgTypes.MSG_RESP_GAINLOTTERY:
        msg = new MsgRespGainLottery();
        break;
      case MsgTypes.MSG_RESP_LOTTERYSTATUS:
        msg = new MsgRespLotteryStatus();
        break;
      case MsgTypes.MSG_RESP_PROPSINFO:
        msg = new MsgRespPropsInfo();
        break;
      case MsgTypes.MSG_RESP_PROPSMOVE:
        msg = new MsgRespPropsMove();
        break;
      case MsgTypes.MSG_RESP_SPEEDTECH:
        msg = new MsgRespSpeedTech();
        break;
      case MsgTypes.MSG_RESP_TECHINFO:
        msg = new MsgRespTechInfo();
        break;
      case MsgTypes.MSG_RESP_TECHUPGRADEINFO:
        msg = new MsgRespTechUpgradeInfo();
        break;
      case MsgTypes.MSG_RESP_UNBINDCOMMANDERCARD:
        msg = new MsgRespUnbindCommanderCard();
        break;
      case MsgTypes.MSG_RESP_USEPROPS:
        msg = new MsgRespUseProps();
        break;
      case MsgTypes.MSG_RESP_ECTYPEPASS:
        msg = new MsgRespEcTypePass();
        break;
      default:
        break;
    }
    
    if(msg != null) {
      msg.readBuf(new ByteArray(b));
    }
    return msg;
  }
}
