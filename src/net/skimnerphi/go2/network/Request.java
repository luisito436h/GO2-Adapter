package net.skimnerphi.go2.network;

import com.igg.go2.msg.MsgRequestDeleteServer;
import com.igg.go2.msg.chat.MsgChatMessage;
import com.igg.go2.msg.chiplottery.MsgRequestCmosLotteryInfo;
import com.igg.go2.msg.chiplottery.MsgRequestGainCmosLottery;
import com.igg.go2.msg.chiplottery.MsgRequestSellProps;
import com.igg.go2.msg.compose.MsgRequestCommanderUnionStone;
import com.igg.go2.msg.compose.MsgRequestUnionCommanderCard;
import com.igg.go2.msg.construction.MsgRequestCreateBuild;
import com.igg.go2.msg.construction.MsgRequestGetStorageResource;
import com.igg.go2.msg.construction.MsgRequestSpeedBuilding;
import com.igg.go2.msg.corps.MsgRequestInsertFlagConsortiaMember;
import com.igg.go2.msg.corps.MsgRequestJoinConsortia;
import com.igg.go2.msg.mail.MsgRequestDeleteEmail;
import com.igg.go2.msg.mail.MsgRequestEmailGoods;
import com.igg.go2.msg.mail.MsgRequestEmailInfo;
import com.igg.go2.msg.mail.MsgRequestReadEmail;
import com.igg.go2.msg.mail.MsgRequestSendEmail;
import com.igg.go2.msg.mall.MsgRequestBuyTradeGoods;
import com.igg.go2.msg.mall.MsgRequestMyTradeInfo;
import com.igg.go2.msg.mall.MsgRequestTradeGoods;
import com.igg.go2.msg.mall.MsgRequestTradeInfo;
import com.igg.go2.msg.sciencesystem.MsgRequestAddPack;
import com.igg.go2.msg.sciencesystem.MsgRequestGainLottery;
import com.igg.go2.msg.sciencesystem.MsgRequestUseProps;
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
}
