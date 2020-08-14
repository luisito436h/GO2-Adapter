package net.skimnerphi.go2.network;

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
import java.io.IOException;

public class Request {
  private Connection inst;
  
  public Request(Connection instance) {
    this.inst = instance;
  }
  
  public void joinCorps(int corpsId) throws IOException {
    MsgRequestJoinConsortia req = new MsgRequestJoinConsortia();
    req.guid = inst.guid();
    req.consortiaId = corpsId;
    inst.sendMsg(req);
  }
  
  public void openBagSlot() throws IOException {
    MsgRequestAddPack req = new MsgRequestAddPack();
    req.guid = inst.guid();
    inst.sendMsg(req);
  }
  
  public void collectWarehouseResources() throws IOException {
    MsgRequestGetStorageResource req = new MsgRequestGetStorageResource();
    req.guid = inst.guid();
    inst.sendMsg(req);
  }
  
  public void buildStructure(int structureId, int posX, int posY) throws IOException {
    MsgRequestCreateBuild req = new MsgRequestCreateBuild();
    req.guid = inst.guid();
    req.indexId = -1;
    req.buildingId = structureId;
    req.posX = (short)posX;
    req.posY = (short)posY;
    inst.sendMsg(req);
  }
  public void upgradeStructure(int structureIndex) throws IOException {
    MsgRequestCreateBuild req = new MsgRequestCreateBuild();
    req.guid = inst.guid();
    req.indexId = structureIndex;
    inst.sendMsg(req);
  }
  public void finishStructure(int structureIndex) throws IOException {
    MsgRequestSpeedBuilding req = new MsgRequestSpeedBuilding();
    req.guid = inst.guid();
    req.indexId = structureIndex;
    req.buildingSpeedId = 4;
    req.type = 1;
    inst.sendMsg(req);
  }
  
  public void emailInfo(int page) throws IOException {
    MsgRequestEmailInfo req = new MsgRequestEmailInfo();
    req.guid = inst.guid();
    req.pageId = page;
    req.readFlag = -1;
    req.type = -1;
    inst.sendMsg(req);
  }
  public void sendEmail(int targetId, String head, String body) throws IOException {
    MsgRequestSendEmail req = new MsgRequestSendEmail();
    req.guid = inst.guid();
    req.sendGuid = targetId;
    req.title = head;
    req.content = body;
    inst.sendMsg(req);
  }
  public void readEmail(int id) throws IOException {
    MsgRequestReadEmail req = new MsgRequestReadEmail();
    req.guid = inst.guid();
    req.autoId = id;
    inst.sendMsg(req);
  }
  public void getEmailGoods(int id) throws IOException {
    MsgRequestEmailGoods req = new MsgRequestEmailGoods();
    req.guid = inst.guid();
    req.autoId = id;
    req.propsId = -1;
    inst.sendMsg(req);
  }
  public void deleteEmail(int id) throws IOException {
    MsgRequestDeleteEmail req = new MsgRequestDeleteEmail();
    req.guid = inst.guid();
    req.autoId = id;
    inst.sendMsg(req);
  }
  
  public void useProp(int propId, boolean bound) throws IOException {
    useProps(propId, bound, 1, true);
  }
  public void useProps(int propId, boolean bound, int num, boolean nativeMulti) throws IOException {
    MsgRequestUseProps req = new MsgRequestUseProps();
    req.guid = inst.guid();
    req.propsId = propId;
    req.lockFlag = (bound)? 1:0;
    if(nativeMulti) {
      req.num = num;
      inst.sendMsg(req);
    } else {
      req.num = 1;
      for(int idx = 0; idx < num; idx++) {
        inst.sendMsg(req);
      }
    }
  }
  
  public void mergeRawGem() throws IOException {
    mergeGem(1119);
  }
  public void mergeGem(int propId) throws IOException {
    MsgRequestCommanderUnionStone req = new MsgRequestCommanderUnionStone();
    req.guid = inst.guid();
    req.propsId = propId;
    req.lockFlag = 1;
    inst.sendMsg(req);
  }
  
  public static final int PROP_MERGECHIP = 925;
  public static final int PROP_ADVMERGECHIP = 944;
  
  public void mergeCommanderSame(int comm) throws IOException {
    mergeCommander(comm, comm, -1, -1, false);
  }
  public void mergeCommanderSame(int comm, int propId, boolean propBound) throws IOException {
    mergeCommander(comm, comm, -1, propId, propBound);
  }
  private void mergeCommander(int comm1, int comm2, int comm3, int propId, boolean propBound) throws IOException {
    MsgRequestUnionCommanderCard req = new MsgRequestUnionCommanderCard();
    req.guid = inst.guid();
    req.card1 = comm1;
    req.card2 = comm2;
    req.card3 = comm3;
    req.goods = propId;
    req.goodsLockFlag = propBound?1:0;
    inst.sendMsg(req);
  }
  
  public void getCorpUserList(int corpsId, int page) throws IOException {
    MsgRequestInsertFlagConsortiaMember req = new MsgRequestInsertFlagConsortiaMember();
    req.guid = inst.guid();
    req.consortiaId = corpsId;
    req.pageId = page;
    inst.sendMsg(req);
  }
  
  public void sellPropsForCG(int propId, boolean bound, int num) throws IOException {
    MsgRequestSellProps req = new MsgRequestSellProps();
    req.guid = inst.guid();
    req.id = propId;
    req.lockFlag = (bound)? 1:0;
    req.num = num;
    inst.sendMsg(req);
  }
  
  public void chipInfo() throws IOException {
    MsgRequestCmosLotteryInfo req = new MsgRequestCmosLotteryInfo();
    req.guid = inst.guid();
    inst.sendMsg(req);
  }
  
  public void generateChip(int tier) throws IOException {
    MsgRequestGainCmosLottery req = new MsgRequestGainCmosLottery();
    req.guid = inst.guid();
    req.phaseId = tier;
    inst.sendMsg(req);
  }
  
  public void spinWheel(boolean voucher) throws IOException {
    MsgRequestGainLottery req = new MsgRequestGainLottery();
    req.guid = inst.guid();
    req.type = (voucher)? 2:0;
    inst.sendMsg(req);
  }
  
  public void postTrade(int propId, int num, int cost) throws IOException {
    MsgRequestTradeGoods req = new MsgRequestTradeGoods();
    req.guid = inst.guid();
    req.id = propId;
    req.num = num;
    req.price = cost;
    req.tradeType = 1;
    inst.sendMsg(req);
  }
  
  public void buyTrade(int sellGuid, int index) throws IOException {
    MsgRequestBuyTradeGoods req = new MsgRequestBuyTradeGoods();
    req.guid = inst.guid();
    req.sellGuid = sellGuid;
    req.indexId = index;
    inst.sendMsg(req);
  }
  
  public static final int TRADE_CARD = 3;
  
  public void tradeInfo(int type, int page) throws IOException {
    MsgRequestTradeInfo req = new MsgRequestTradeInfo();
    req.guid = inst.guid();
    req.pageId = page;
    req.type = type;
    req.id = -1;
    inst.sendMsg(req);
  }
  
  public void myTradeInfo() throws IOException {
    MsgRequestMyTradeInfo req = new MsgRequestMyTradeInfo();
    req.guid = inst.guid();
    inst.sendMsg(req);
  }
  
  public void deleteServer() throws IOException {
    MsgRequestDeleteServer req = new MsgRequestDeleteServer();
    req.guid = inst.guid();
    req.userId = inst.fbid();
    inst.sendMsg(req);
  }
  
  public static final int CHANNEL_GLOBAL = 0;
  public static final int CHANNEL_PLANET = 1;
  public static final int CHANNEL_CORPS = 2;
  public static final int CHANNEL_PRIVATE = 3;
  
  public static final int LINK_NONE = 0;
  public static final int LINK_PROP = 1;
  public static final int LINK_COMMANDER = 3;
  
  public void chatMessage(String message, int channel) throws IOException {
    chatMessage(message, channel, 0, LINK_NONE, -1);
  }
  public void dmMessage(String message, int dmUserId) throws IOException {
    chatMessage(message, CHANNEL_PRIVATE, dmUserId, LINK_NONE, -1);
  }
  public void chatMessage(String message, int channel, int dmUserId, int linkType, int linkId) throws IOException {
    MsgChatMessage req = new MsgChatMessage();
    req.guid = inst.guid();
    req.buffer = message;
    req.type = (short)channel;
    req.objGuid = dmUserId;
    req.specialType = (short)linkType;
    req.propsId = linkId;
    inst.sendMsg(req);
  }
  
  public static final byte TARGETRANGE_MIN = 0;
  public static final byte TARGETRANGE_MAX = 1;
  
  public static final byte TARGET_CLOSEST = 0;
  public static final byte TARGET_DEFBLDGS = 1;
  public static final byte TARGET_MAXATK = 2;
  public static final byte TARGET_MINATK = 3;
  public static final byte TARGET_MAXDUR = 4;
  public static final byte TARGET_MINDUR = 5;
  public static final byte TARGET_COMMANDER = 6;
  
  public void createFleet(String name, int[] shipIds, int[] stackSizes, int commanderId, byte targetType, byte targetRange) throws IOException {
    MsgRequestCreateShipTeam req = new MsgRequestCreateShipTeam();
    req.guid = inst.guid();
    req.teamName = name;
    req.commanderId = commanderId;
    req.target = targetType;
    req.targetInterval = targetRange;
    
    for(int idx = 0; idx < MsgTypes.MAX_SHIPTEAMBODY; idx++) {
      req.teamBody[idx].shipModelId = shipIds[idx];
      req.teamBody[idx].num = shipIds[idx];
    }
    
    inst.sendMsg(req);
  }
  
  public static final byte JUMP_DEFEND = 0;
  public static final byte JUMP_ATTACK = 1;
  
  public void sendFleets(int destX, int destY, byte jumpType, boolean sync, int... fleetIds) throws IOException {
    sendFleets(destX * 420 + destY, jumpType, sync, fleetIds);
  }
  public void sendFleets(int destGalaxyId, byte jumpType, boolean sync, int... fleetIds) throws IOException {
    MsgRequestJumpShipTeam req = new MsgRequestJumpShipTeam();
    req.guid = inst.guid();
    req.toGalaxyMapId = 0;
    req.toGalaxyId = destGalaxyId;
    req.dataLen = (short)fleetIds.length;
    req.jumpType = jumpType;
    req.type = (sync) ? (byte)1 : (byte)0;
    
    for(int idx = 0; idx < fleetIds.length; idx++) {
      req.shipTeamId[idx] = fleetIds[idx];
    }
    
    inst.sendMsg(req);
  }
  
  public void getPlayerInfo(int guid) throws IOException {
    MsgRequestFriendInfo req = new MsgRequestFriendInfo();
    req.guid = inst.guid();
    req.objGuid = guid;
    req.objUserId = -1;
    inst.sendMsg(req);
  }
  public void getPlayerInfo(long fbid) throws IOException {
    MsgRequestFriendInfo req = new MsgRequestFriendInfo();
    req.guid = inst.guid();
    req.objGuid = -1;
    req.objUserId = fbid;
    inst.sendMsg(req);
  }
  
  public void enterPlanet(int x, int y) throws IOException {
    enterPlanet(x * 420 + y);
  }
  public void enterPlanet(int galaxyId) throws IOException {
    MsgRequestGalaxy req = new MsgRequestGalaxy();
    req.guid = inst.guid();
    req.galaxyMapId = 0;
    req.galaxyId = galaxyId;
    inst.sendMsg(req);
  }
}
