--comment:登录状态下在“我的”页面点击“个人资料”按钮，退出，点击“我的奖品”按钮，向左滑屏2次，退出，向上滑屏2次，点击“推荐”按钮，随机点击一部视频观看，随机向左或向上滑屏2-6次，退出应用。
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
  
  mSleep(math.random(3376, 5162));
  touchDown(0, 551 + math.random(-32, 32), 356 + math.random(-29, 32));  --点击“个人资料”按钮
  mSleep(math.random(19, 47));
  touchUp(0);
  
  mSleep(math.random(3376, 4462));
  touchDown(0, 51 + math.random(-12, 23), 152 + math.random(-49, 54));  --退出“个人资料”界面
  mSleep(math.random(12, 33));
  touchUp(0);
  
  mSleep(math.random(2251, 3125));
  touchDown(0, 901 + math.random(-56, 126), 849 + math.random(-84, 106));  --点击“我的奖品”按钮
  mSleep(math.random(8, 25));
  touchUp(0);
  
  mSleep(math.random(2151, 3225));
  touchDown(0, 912, 1014);  --向左滑屏
  mSleep(73);
  touchMove(0, 827, 1018);
  mSleep(8);
  touchMove(0, 785, 1027);
  mSleep(9);
  touchMove(0, 740, 1036);
  mSleep(8);
  touchMove(0, 698, 1044);
  mSleep(8);
  touchMove(0, 657, 1053);
  mSleep(7);
  touchMove(0, 620, 1061);
  mSleep(8);
  touchMove(0, 579, 1068);
  mSleep(9);
  touchMove(0, 540, 1076);
  mSleep(8);
  touchMove(0, 493, 1083);
  mSleep(16);
  touchUp(0);

  mSleep(math.random(1345, 2018));
  touchDown(0, 919, 999);  --向左滑屏
  mSleep(82);
  touchMove(0, 812, 1005);
  mSleep(9);
  touchMove(0, 778, 1008);
  mSleep(8);
  touchMove(0, 740, 1014);
  mSleep(11);
  touchMove(0, 697, 1020);
  mSleep(5);
  touchMove(0, 652, 1027);
  mSleep(10);
  touchMove(0, 610, 1035);
  mSleep(7);
  touchMove(0, 566, 1044);
  mSleep(9);
  touchMove(0, 526, 1053);
  mSleep(8);
  touchMove(0, 480, 1065);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(1851, 2485));
  touchDown(0, 81 + math.random(-46, 13), 138 + math.random(-30, 44));  --退出“我的奖品”界面
  mSleep(math.random(9, 25));
  touchUp(0);
  
  mSleep(math.random(2864, 3321));
  touchDown(0, 719, 1539);  --向上滑屏
  mSleep(101);
  touchMove(0, 721, 1453);
  mSleep(8);
  touchMove(0, 722, 1441);
  mSleep(9);
  touchMove(0, 723, 1425);
  mSleep(9);
  touchMove(0, 725, 1402);
  mSleep(8);
  touchMove(0, 726, 1383);
  mSleep(7);
  touchMove(0, 729, 1368);
  mSleep(9);
  touchMove(0, 734, 1351);
  mSleep(9);
  touchMove(0, 738, 1331);
  mSleep(8);
  touchMove(0, 742, 1312);
  mSleep(8);
  touchMove(0, 748, 1293);
  mSleep(10);
  touchMove(0, 756, 1276);
  mSleep(7);
  touchMove(0, 765, 1260);
  mSleep(8);
  touchMove(0, 783, 1231);
  mSleep(10);
  touchMove(0, 797, 1211);
  mSleep(16);
  touchUp(0);

  mSleep(math.random(1594, 2386));
  touchDown(0, 734, 1576);  --向上滑屏
  mSleep(83);
  touchMove(0, 729, 1531);
  mSleep(24);
  touchMove(0, 733, 1458);
  mSleep(9);
  touchMove(0, 736, 1436);
  mSleep(8);
  touchMove(0, 741, 1396);
  mSleep(9);
  touchMove(0, 747, 1366);
  mSleep(10);
  touchMove(0, 756, 1329);
  mSleep(7);
  touchMove(0, 768, 1293);
  mSleep(8);
  touchMove(0, 783, 1265);
  mSleep(11);
  touchUp(0);
  
  mSleep(math.random(2065, 3233));
  touchDown(0, 111 + math.random(-12, 12), 1826 + math.random(-17, 25)); --点击“推荐”按钮
  mSleep(math.random(8,19));
  touchUp(0);
  
  mSleep(math.random(2817, 3391));
  local i = math.random(1, 4);
  if i == 1 then
    touchDown(0, 258 + math.random(-157, 195), 1111 + math.random(-97, 131));  --点击视频
    mSleep(math.random(12, 27));
    touchUp(0);
  elseif i == 2 then
    touchDown(0, 800 + math.random(-172, 177), 1111 + math.random(-97, 131));  --点击视频
    mSleep(math.random(10, 27));
    touchUp(0);
  elseif i == 3 then
    touchDown(0, 258 + math.random(-157, 195), 1642 + math.random(-84, 80));  --点击视频
    mSleep(math.random(9, 21));
    touchUp(0);
  else
    touchDown(0, 688 + math.random(-108, 125), 1642 + math.random(-84, 80));  --点击视频
    mSleep(math.random(12, 32));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可替换
  os.execute("input keyevent 4");
  
  if 1 == math.random(1, 2) then
    mSleep(math.random(2876, 3605));
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

    mSleep(math.random(1043, 1827));
    touchDown(0, 595, 1582);  --向上滑屏
    mSleep(49);
    touchMove(0, 591, 1530);
    mSleep(16);
    touchMove(0, 595, 1468);
    mSleep(9);
    touchMove(0, 600, 1441);
    mSleep(8);
    touchMove(0, 608, 1398);
    mSleep(8);
    touchMove(0, 618, 1365);
    mSleep(9);
    touchMove(0, 638, 1320);
    mSleep(15);
    touchUp(0);

    mSleep(math.random(1111, 1598));
    touchDown(0, 605, 1573);  --向上滑屏
    mSleep(66);
    touchMove(0, 609, 1486);
    mSleep(9);
    touchMove(0, 613, 1456);
    mSleep(8);
    touchMove(0, 622, 1428);
    mSleep(8);
    touchMove(0, 634, 1383);
    mSleep(9);
    touchMove(0, 645, 1357);
    mSleep(15);
    touchUp(0);

    mSleep(math.random(1346, 1960));
    touchDown(0, 588, 1576);  --向上滑屏
    mSleep(65);
    touchMove(0, 593, 1492);
    mSleep(9);
    touchMove(0, 599, 1462);
    mSleep(9);
    touchMove(0, 605, 1440);
    mSleep(7);
    touchMove(0, 621, 1393);
    mSleep(9);
    touchMove(0, 633, 1363);
    mSleep(9);
    touchMove(0, 652, 1323);
    mSleep(15);
    touchUp(0);

    mSleep(math.random(1241, 2077));
    touchDown(0, 627, 1552);  --向上滑屏
    mSleep(57);
    touchMove(0, 631, 1511);
    mSleep(8);
    touchMove(0, 637, 1481);
    mSleep(9);
    touchMove(0, 641, 1456);
    mSleep(8);
    touchMove(0, 648, 1430);
    mSleep(7);
    touchMove(0, 658, 1387);
    mSleep(8);
    touchMove(0, 665, 1361);
    mSleep(8);
    touchMove(0, 679, 1323);
    mSleep(16);
    touchUp(0);

    mSleep(math.random(868, 1122));
    touchDown(0, 665, 1479);  --向上滑屏
    mSleep(57);
    touchMove(0, 669, 1395);
    mSleep(8);
    touchMove(0, 677, 1366);
    mSleep(9);
    touchMove(0, 688, 1327);
    mSleep(9);
    touchMove(0, 703, 1290);
    mSleep(16);
    touchUp(0);
    
    mSleep(math.random(2462, 3389));
    os.execute("input keyevent 4");  --退出应用
    mSleep(math.random(13,54));
    os.execute("input keyevent 4");
    mSleep(math.random(13,54));
    os.execute("input keyevent 4");
  else
    mSleep(math.random(2429, 3733));
    touchDown(0, 734, 1091);  --向左滑屏
    mSleep(85);
    touchMove(0, 552, 1085);
    mSleep(37);
    touchMove(0, 333, 1093);
    mSleep(5);
    touchMove(0, 267, 1104);
    mSleep(9);
    touchMove(0, 209, 1123);
    mSleep(15);
    touchUp(0);

    mSleep(math.random(2238, 3350));
    touchDown(0, 693, 1128);  --向左滑屏
    mSleep(50);
    touchMove(0, 645, 1134);
    mSleep(9);
    touchMove(0, 620, 1136);
    mSleep(7);
    touchMove(0, 579, 1140);
    mSleep(8);
    touchMove(0, 536, 1141);
    mSleep(9);
    touchMove(0, 488, 1143);
    mSleep(8);
    touchMove(0, 431, 1145);
    mSleep(9);
    touchMove(0, 368, 1147);
    mSleep(15);
    touchUp(0);
    
    mSleep(math.random(2462, 3389));
    os.execute("input keyevent 4");  --退出应用
    mSleep(math.random(13,54));
    os.execute("input keyevent 4");
    mSleep(math.random(13,54));
    os.execute("input keyevent 4");
  end

end
