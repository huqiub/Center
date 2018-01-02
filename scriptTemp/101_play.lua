--comment:登录状态下在“推荐”页面向上滑动1次，随机点击一部视频观看，退出视频，点击刷新，随机点击一部视频观看，退出视频，向上滑屏1次，退出应用。
-- 适用屏幕参数
SCREEN_RESOLUTION="1080x1920";
SCREEN_COLOR_BITS=32;

function exec(tab1)
  
  math.randomseed(tostring(os.time()):reverse():sub(1, 6));
  
  mSleep(math.random(2509, 3278));
  touchDown(0, 971 + math.random(-50, 50), 1851 + math.random(-72, 72)); --点击“我的”按钮
  mSleep(math.random(13, 28))
  touchUp(0);
  
  mSleep(math.random(2437, 3896));
  touchDown(0, 542 + math.random(-63, 63), 646 + math.random(-31, -31));  --点击“登录”按钮
  mSleep(math.random(28, 52));
  touchUp(0);
  
  mSleep(math.random(2273, 3711));
  touchDown(0, 555 + math.random(-154, 211), 603 + math.random(-18, 25));  --点击账号输入框
  mSleep(math.random(21, 79));
  touchUp(0);
  
  mSleep(math.random(2669, 3828));
  inputText(tab1[1]);  --输入账号
  
  mSleep(math.random(2269, 2931));
  touchDown(0, 556 + math.random(-172, 172), 744 + math.random(-18, 21));  --点击密码输入框
  mSleep(math.random(31, 83));
  touchUp(0);
  
  mSleep(math.random(2169, 2835));
  inputText(tab1[2]);  --输入密码
  
  mSleep(math.random(2387, 3122));
  touchDown(0, 532 + math.random(-138, 162), 948 + math.random(-23, 23));  --点击“登录”按钮     
  mSleep(math.random(15, 37));
  touchUp(0);
  
  mSleep(math.random(4227, 5349));
  touchDown(0, 549 + math.random(-44, 32), 1586 + math.random(-34, 47));  --关闭登录弹窗
  mSleep(math.random(12, 31));
  touchUp(0);
  
  mSleep(math.random(3675, 5587));
  os.execute("input keyevent 4");  --点击Back键
  
  mSleep(math.random(4217, 5891));
  touchDown(0, 111 + math.random(-12, 12), 1826 + math.random(-17, 25)); --点击“推荐”按钮
  mSleep(math.random(8,19));
  touchUp(0);
  
  mSleep(math.random(4541, 6326));
  touchDown(0, 678, 1505);  --向上滑屏
  mSleep(97);
  touchMove(0, 656, 1456);
  mSleep(7);
  touchMove(0, 653, 1443);
  mSleep(8);
  touchMove(0, 652, 1432);
  mSleep(9);
  touchMove(0, 650, 1411);
  mSleep(6);
  touchMove(0, 649, 1383);
  mSleep(26);
  touchMove(0, 651, 1331);
  mSleep(8);
  touchMove(0, 652, 1310);
  mSleep(8);
  touchMove(0, 653, 1295);
  mSleep(9);
  touchMove(0, 656, 1284);
  mSleep(7);
  touchMove(0, 659, 1273);
  mSleep(9);
  touchMove(0, 662, 1263);
  mSleep(8);
  touchMove(0, 665, 1250);
  mSleep(9);
  touchMove(0, 669, 1231);
  mSleep(8);
  touchMove(0, 673, 1215);
  mSleep(9);
  touchMove(0, 678, 1201);
  mSleep(8);
  touchMove(0, 682, 1188);
  mSleep(9);
  touchMove(0, 686, 1173);
  mSleep(9);
  touchMove(0, 691, 1151);
  mSleep(8);
  touchMove(0, 696, 1136);
  mSleep(8);
  touchMove(0, 700, 1125);
  mSleep(9);
  touchMove(0, 704, 1113);
  mSleep(8);
  touchMove(0, 707, 1106);
  mSleep(9);
  touchMove(0, 710, 1096);
  mSleep(8);
  touchMove(0, 715, 1089);
  mSleep(8);
  touchMove(0, 718, 1081);
  mSleep(9);
  touchMove(0, 722, 1072);
  mSleep(9);
  touchMove(0, 726, 1063);
  mSleep(9);
  touchMove(0, 731, 1053);
  mSleep(8);
  touchMove(0, 738, 1042);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(2459, 3517));
  local i = math.random(1, 4)
  if i == 1 then
    touchDown(0, 263 + math.random(-177, 184), 613 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  elseif i == 2 then
    touchDown(0, 817 + math.random(-177, 184), 613 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  elseif i == 3 then
    touchDown(0, 263 + math.random(-177, 184), 1166 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  else
    touchDown(0, 817 + math.random(-177, 184), 1166 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可以替换
  os.execute("input keyevent 4");  --退出视频
  
  mSleep(math.random(2185, 3049));
  touchDown(0, 862 + math.random(-19, 19), 373 + math.random(-16, 9))  --点击刷新按钮
  mSleep(math.random(9, 21));
  touchUp(0);
  
  mSleep(math.random(2459, 3517));
  local j = math.random(1, 4)
  if j == 1 then
    touchDown(0, 263 + math.random(-177, 184), 613 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  elseif j == 2 then
    touchDown(0, 817 + math.random(-177, 184), 613 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  elseif j == 3 then
    touchDown(0, 263 + math.random(-177, 184), 1166 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  else
    touchDown(0, 817 + math.random(-177, 184), 1166 + math.random(-98, 108));  --点击视频
    mSleep(math.random(11,27));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可以替换
  os.execute("input keyevent 4");  --退出视频
  
  mSleep(math.random(4541, 6326));
  touchDown(0, 678, 1505);  --向上滑屏
  mSleep(97);
  touchMove(0, 656, 1456);
  mSleep(7);
  touchMove(0, 653, 1443);
  mSleep(8);
  touchMove(0, 652, 1432);
  mSleep(9);
  touchMove(0, 650, 1411);
  mSleep(6);
  touchMove(0, 649, 1383);
  mSleep(26);
  touchMove(0, 651, 1331);
  mSleep(8);
  touchMove(0, 652, 1310);
  mSleep(8);
  touchMove(0, 653, 1295);
  mSleep(9);
  touchMove(0, 656, 1284);
  mSleep(7);
  touchMove(0, 659, 1273);
  mSleep(9);
  touchMove(0, 662, 1263);
  mSleep(8);
  touchMove(0, 665, 1250);
  mSleep(9);
  touchMove(0, 669, 1231);
  mSleep(8);
  touchMove(0, 673, 1215);
  mSleep(9);
  touchMove(0, 678, 1201);
  mSleep(8);
  touchMove(0, 682, 1188);
  mSleep(9);
  touchMove(0, 686, 1173);
  mSleep(9);
  touchMove(0, 691, 1151);
  mSleep(8);
  touchMove(0, 696, 1136);
  mSleep(8);
  touchMove(0, 700, 1125);
  mSleep(9);
  touchMove(0, 704, 1113);
  mSleep(8);
  touchMove(0, 707, 1106);
  mSleep(9);
  touchMove(0, 710, 1096);
  mSleep(8);
  touchMove(0, 715, 1089);
  mSleep(8);
  touchMove(0, 718, 1081);
  mSleep(9);
  touchMove(0, 722, 1072);
  mSleep(9);
  touchMove(0, 726, 1063);
  mSleep(9);
  touchMove(0, 731, 1053);
  mSleep(8);
  touchMove(0, 738, 1042);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(2338, 3449));
  os.execute("input keyevent 4");  --退出应用
  mSleep(math.random(12, 29));
  os.execute("input keyevent 4");
  mSleep(math.random(12, 29));
  os.execute("input keyevent 4");
  
end
