--comment:非登录状态下在“视频”页面向上滑动1次，随机点击一部视频观看，退出视频，向上滑屏3次，随机点击一部视频观看，退出视频，向上滑屏2次，点击“推荐”按钮，随机向上滑屏1次，退出应用。
-- 适用屏幕参数
SCREEN_RESOLUTION="1080x1920";
SCREEN_COLOR_BITS=32;

function exec(tab1)
  
  math.randomseed(tostring(os.time()):reverse():sub(1, 6));
  
  mSleep(math.random(4856, 5579));
  touchDown(0, 621 + math.random(-29, 29), 262 + math.random(-39, 39))  --点击“视频”按钮
  mSleep(math.random(8, 41));
  touchUp(0);
  
  mSleep(math.random(2756, 3627));
  touchDown(0, 380, 1601);  --向上滑屏
  mSleep(98);
  touchMove(0, 375, 1563);
  mSleep(8);
  touchMove(0, 374, 1554);
  mSleep(8);
  touchMove(0, 372, 1543);
  mSleep(8);
  touchMove(0, 371, 1533);
  mSleep(9);
  touchMove(0, 369, 1522);
  mSleep(8);
  touchMove(0, 367, 1513);
  mSleep(9);
  touchMove(0, 364, 1501);
  mSleep(8);
  touchMove(0, 361, 1490);
  mSleep(8);
  touchMove(0, 359, 1479);
  mSleep(9);
  touchMove(0, 356, 1468);
  mSleep(8);
  touchMove(0, 353, 1456);
  mSleep(9);
  touchMove(0, 350, 1445);
  mSleep(8);
  touchMove(0, 346, 1436);
  mSleep(8);
  touchMove(0, 343, 1426);
  mSleep(9);
  touchMove(0, 339, 1415);
  mSleep(10);
  touchMove(0, 335, 1404);
  mSleep(8);
  touchMove(0, 330, 1391);
  mSleep(9);
  touchMove(0, 325, 1380);
  mSleep(7);
  touchMove(0, 321, 1368);
  mSleep(8);
  touchMove(0, 317, 1357);
  mSleep(8);
  touchMove(0, 312, 1346);
  mSleep(9);
  touchMove(0, 307, 1338);
  mSleep(8);
  touchMove(0, 303, 1329);
  mSleep(8);
  touchMove(0, 298, 1318);
  mSleep(8);
  touchMove(0, 293, 1308);
  mSleep(8);
  touchMove(0, 288, 1299);
  mSleep(9);
  touchMove(0, 283, 1291);
  mSleep(7);
  touchMove(0, 280, 1284);
  mSleep(8);
  touchMove(0, 275, 1278);
  mSleep(7);
  touchMove(0, 272, 1271);
  mSleep(8);
  touchMove(0, 267, 1267);
  mSleep(10);
  touchMove(0, 264, 1261);
  mSleep(6);
  touchMove(0, 260, 1258);
  mSleep(8);
  touchMove(0, 257, 1252);
  mSleep(8);
  touchMove(0, 254, 1248);
  mSleep(9);
  touchMove(0, 249, 1245);
  mSleep(9);
  touchMove(0, 246, 1241);
  mSleep(8);
  touchMove(0, 243, 1239);
  mSleep(9);
  touchMove(0, 241, 1235);
  mSleep(8);
  touchMove(0, 238, 1233);
  mSleep(8);
  touchMove(0, 236, 1230);
  mSleep(8);
  touchMove(0, 233, 1226);
  mSleep(9);
  touchMove(0, 230, 1224);
  mSleep(9);
  touchMove(0, 228, 1222);
  mSleep(8);
  touchMove(0, 226, 1218);
  mSleep(8);
  touchMove(0, 223, 1216);
  mSleep(7);
  touchMove(0, 221, 1213);
  mSleep(8);
  touchMove(0, 219, 1211);
  mSleep(8);
  touchMove(0, 217, 1207);
  mSleep(9);
  touchMove(0, 215, 1205);
  mSleep(8);
  touchMove(0, 213, 1201);
  mSleep(7);
  touchMove(0, 210, 1200);
  mSleep(8);
  touchMove(0, 208, 1198);
  mSleep(7);
  touchMove(0, 207, 1194);
  mSleep(8);
  touchMove(0, 205, 1192);
  mSleep(9);
  touchMove(0, 204, 1190);
  mSleep(9);
  touchMove(0, 202, 1188);
  mSleep(8);
  touchMove(0, 200, 1186);
  mSleep(8);
  touchMove(0, 197, 1183);
  mSleep(8);
  touchMove(0, 195, 1181);
  mSleep(8);
  touchMove(0, 191, 1177);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(2859, 3391));
  local i = math.random(1, 4);
  if i == 1 then
    touchDown(0, 252 + math.random(-160, 211), 705 + math.random(-98, 121));  -- 点击视频
    mSleep(math.random(15, 31));
    touchUp(0);
  elseif i == 2 then
    touchDown(0, 805 + math.random(-160, 211), 705 + math.random(-98, 121));  -- 点击视频
    mSleep(math.random(15, 31));
    touchUp(0);
  elseif i == 3 then
    touchDown(0, 252 + math.random(-160, 211), 1260 + math.random(-98, 121));  -- 点击视频
    mSleep(math.random(15, 31));
    touchUp(0);
  else
    touchDown(0, 805 + math.random(-160, 211), 1260 + math.random(-98, 121));  -- 点击视频
    mSleep(math.random(15, 31));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可替换
  os.execute("input keyevent 4");
  
  mSleep(math.random(2127, 3682));
  touchDown(0, 475, 1599); --向上滑屏
  mSleep(108);
  touchMove(0, 471, 1550);
  mSleep(7);
  touchMove(0, 468, 1537);
  mSleep(11);
  touchMove(0, 465, 1524);
  mSleep(5);
  touchMove(0, 461, 1513);
  mSleep(10);
  touchMove(0, 457, 1498);
  mSleep(6);
  touchMove(0, 452, 1479);
  mSleep(9);
  touchMove(0, 449, 1462);
  mSleep(7);
  touchMove(0, 445, 1447);
  mSleep(9);
  touchMove(0, 441, 1434);
  mSleep(8);
  touchMove(0, 437, 1417);
  mSleep(9);
  touchMove(0, 432, 1400);
  mSleep(7);
  touchMove(0, 428, 1383);
  mSleep(9);
  touchMove(0, 423, 1368);
  mSleep(7);
  touchMove(0, 418, 1355);
  mSleep(10);
  touchMove(0, 414, 1342);
  mSleep(6);
  touchMove(0, 408, 1325);
  mSleep(11);
  touchMove(0, 401, 1310);
  mSleep(6);
  touchMove(0, 394, 1295);
  mSleep(9);
  touchMove(0, 388, 1280);
  mSleep(8);
  touchMove(0, 381, 1267);
  mSleep(9);
  touchMove(0, 373, 1252);
  mSleep(7);
  touchMove(0, 363, 1230);
  mSleep(9);
  touchMove(0, 354, 1209);
  mSleep(16);
  touchUp(0);

  mSleep(math.random(1710, 2367));
  touchDown(0, 664, 1560);  --向上滑屏
  mSleep(93);
  touchMove(0, 652, 1513);
  mSleep(5);
  touchMove(0, 650, 1486);
  mSleep(25);
  touchMove(0, 653, 1428);
  mSleep(7);
  touchMove(0, 656, 1398);
  mSleep(8);
  touchMove(0, 659, 1376);
  mSleep(8);
  touchMove(0, 662, 1363);
  mSleep(9);
  touchMove(0, 666, 1344);
  mSleep(9);
  touchMove(0, 673, 1318);
  mSleep(7);
  touchMove(0, 681, 1293);
  mSleep(10);
  touchMove(0, 692, 1275);
  mSleep(8);
  touchMove(0, 714, 1239);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(1588, 2780));
  touchDown(0, 659, 1648);  --向上滑屏
  mSleep(106);
  touchMove(0, 648, 1601);
  mSleep(17);
  touchMove(0, 650, 1548);
  mSleep(8);
  touchMove(0, 654, 1524);
  mSleep(8);
  touchMove(0, 661, 1490);
  mSleep(10);
  touchMove(0, 669, 1451);
  mSleep(8);
  touchMove(0, 679, 1410);
  mSleep(7);
  touchMove(0, 689, 1374);
  mSleep(8);
  touchMove(0, 701, 1350);
  mSleep(8);
  touchMove(0, 723, 1299);
  mSleep(8);
  touchMove(0, 744, 1254);
  mSleep(12);
  touchUp(0);
  
  mSleep(math.random(2859, 3391));
  local j = math.random(1, 4);
  if j == 1 then
    touchDown(0, 261 + math.random(-175, 197), 410 + math.random(-103, 116));  --点击视频
    mSleep(math.random(12, 32));
    touchUp(0);
  elseif j == 2 then
    touchDown(0, 810 + math.random(-175, 197), 410 + math.random(-103, 116));  --点击视频
    mSleep(math.random(12, 32));
    touchUp(0);
  elseif j == 3 then
    touchDown(0, 261 + math.random(-175, 197), 960 + math.random(-103, 116));  --点击视频
    mSleep(math.random(12, 32));
    touchUp(0);
  else
    touchDown(0, 810 + math.random(-175, 197), 960 + math.random(-103, 116));  --点击视频
    mSleep(math.random(12, 32));
    touchUp(0);
  end 
  
  mSleep(math.random(5798, 7828));
  touchDown(0, 562 + math.random(-210, 253), 418 + math.random(-217, 183));  --点击当前播放视频窗口
  mSleep(math.random(18, 34));
  touchUp(0);
  
  mSleep(math.random(2116, 2935));
  touchDown(0, 994 + math.random(-18, 14), 601 + math.random(-33, 37));  --点击全屏按钮
  mSleep(math.random(11, 42));
  touchUp(0);
  
  mSleep(math.random(2618, 3340));
  touchDown(0, 1025 + math.random(-523, 476), 524 + math.random(-301, 263));  --点击屏幕
  mSleep(math.random(11, 32));
  touchUp(0);
  
  mSleep(math.random(start, end));  --此处时间可以替换
  os.execute("input keyevent 4");  --退出全屏模式
  
  mSleep(math.random(2777, 3485));
  os.execute("input keyevent 4")  --退出视频
  
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
  
  mSleep(math.random(2849, 3318));
  touchDown(0, 389 + math.random(-32, 22), 84 + math.random(-21, 16)); --点击“推荐”按钮
  mSleep(math.random(8,19));
  touchUp(0);
  
  mSleep(math.random(2849, 3318));
  local k = math.random(1, 4)
  if k == 1 then
    touchDown(0, 253 + math.random(-144, 194), 915 + math.random(-102, 127));
    mSleep(math.random(9, 26));
    touchUp(0);
  elseif k == 2 then
    touchDown(0, 821 + math.random(-187, 188), 915 + math.random(-102, 127));
    mSleep(math.random(11, 22));
    touchUp(0);
  elseif k == 3 then
    touchDown(0, 253 + math.random(-144, 194), 1470 + math.random(-107, 131));
    mSleep(math.random(13, 33));
    touchUp(0);
  else
    touchDown(0, 722 + math.random(-128, 78), 1470 + math.random(-107, 131));
    mSleep(math.random(9, 26));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可替换
  os.execute("input keyevent 4");
  
  if 1 == math.random(1, 2) then
    mSleep(math.random(3682, 4311));
    touchDown(0, 507, 1490);  --向上滑屏
    mSleep(105);
    touchMove(0, 511, 1447);
    mSleep(8);
    touchMove(0, 513, 1440);
    mSleep(9);
    touchMove(0, 515, 1432);
    mSleep(8);
    touchMove(0, 517, 1423);
    mSleep(8);
    touchMove(0, 519, 1411);
    mSleep(9);
    touchMove(0, 522, 1398);
    mSleep(8);
    touchMove(0, 525, 1385);
    mSleep(9);
    touchMove(0, 528, 1374);
    mSleep(8);
    touchMove(0, 531, 1363);
    mSleep(9);
    touchMove(0, 534, 1351);
    mSleep(8);
    touchMove(0, 538, 1338);
    mSleep(9);
    touchMove(0, 544, 1323);
    mSleep(8);
    touchMove(0, 548, 1306);
    mSleep(8);
    touchMove(0, 551, 1293);
    mSleep(9);
    touchMove(0, 554, 1280);
    mSleep(8);
    touchMove(0, 557, 1269);
    mSleep(8);
    touchMove(0, 561, 1258);
    mSleep(9);
    touchMove(0, 564, 1243);
    mSleep(8);
    touchMove(0, 567, 1230);
    mSleep(8);
    touchMove(0, 569, 1218);
    mSleep(9);
    touchMove(0, 571, 1205);
    mSleep(8);
    touchMove(0, 573, 1196);
    mSleep(8);
    touchMove(0, 574, 1186);
    mSleep(8);
    touchMove(0, 576, 1177);
    mSleep(9);
    touchMove(0, 577, 1166);
    mSleep(8);
    touchMove(0, 580, 1155);
    mSleep(8);
    touchMove(0, 581, 1143);
    mSleep(9);
    touchMove(0, 583, 1132);
    mSleep(8);
    touchMove(0, 584, 1119);
    mSleep(8);
    touchMove(0, 585, 1108);
    mSleep(8);
    touchMove(0, 586, 1095);
    mSleep(8);
    touchMove(0, 588, 1081);
    mSleep(8);
    touchMove(0, 589, 1066);
    mSleep(8);
    touchMove(0, 590, 1053);
    mSleep(8);
    touchMove(0, 592, 1042);
    mSleep(8);
    touchMove(0, 593, 1031);
    mSleep(8);
    touchMove(0, 594, 1018);
    mSleep(9);
    touchMove(0, 596, 1003);
    mSleep(8);
    touchMove(0, 599, 988);
    mSleep(8);
    touchMove(0, 601, 975);
    mSleep(9);
    touchMove(0, 603, 963);
    mSleep(7);
    touchMove(0, 605, 952);
    mSleep(8);
    touchMove(0, 607, 943);
    mSleep(7);
    touchMove(0, 608, 931);
    mSleep(8);
    touchMove(0, 611, 916);
    mSleep(8);
    touchMove(0, 614, 903);
    mSleep(9);
    touchMove(0, 616, 892);
    mSleep(9);
    touchMove(0, 620, 883);
    mSleep(8);
    touchMove(0, 623, 875);
    mSleep(9);
    touchMove(0, 625, 868);
    mSleep(8);
    touchMove(0, 628, 860);
    mSleep(8);
    touchMove(0, 632, 851);
    mSleep(9);
    touchMove(0, 635, 843);
    mSleep(8);
    touchMove(0, 640, 832);
    mSleep(9);
    touchMove(0, 643, 823);
    mSleep(9);
    touchMove(0, 646, 813);
    mSleep(8);
    touchMove(0, 648, 806);
    mSleep(8);
    touchMove(0, 651, 798);
    mSleep(9);
    touchMove(0, 653, 791);
    mSleep(8);
    touchMove(0, 656, 785);
    mSleep(9);
    touchMove(0, 657, 780);
    mSleep(8);
    touchMove(0, 659, 774);
    mSleep(8);
    touchMove(0, 661, 768);
    mSleep(9);
    touchMove(0, 663, 761);
    mSleep(8);
    touchMove(0, 665, 755);
    mSleep(9);
    touchMove(0, 667, 750);
    mSleep(8);
    touchMove(0, 669, 742);
    mSleep(10);
    touchMove(0, 671, 736);
    mSleep(7);
    touchMove(0, 673, 731);
    mSleep(8);
    touchMove(0, 676, 725);
    mSleep(9);
    touchMove(0, 677, 721);
    mSleep(9);
    touchMove(0, 679, 718);
    mSleep(8);
    touchMove(0, 681, 714);
    mSleep(8);
    touchMove(0, 682, 710);
    mSleep(8);
    touchMove(0, 683, 706);
    mSleep(9);
    touchMove(0, 684, 705);
    mSleep(7);
    touchMove(0, 685, 701);
    mSleep(8);
    touchMove(0, 686, 699);
    mSleep(17);
    touchMove(0, 687, 695);
    mSleep(9);
    touchMove(0, 688, 693);
    mSleep(8);
    touchMove(0, 689, 691);
    mSleep(25);
    touchMove(0, 690, 690);
    mSleep(17);
    touchMove(0, 691, 688);
    mSleep(17);
    touchUp(0);
    
    mSleep(math.random(3682, 4311));
    os.execute("input keyevent 4")  --退出应用
    mSleep(math.random(17,61));
    os.execute("input keyevent 4");
    mSleep(math.random(11,36));
    os.execute("input keyevent 4") 
  else
    mSleep(math.random(3682, 4311));
    os.execute("input keyevent 4")  --退出应用
    mSleep(math.random(17,61));
    os.execute("input keyevent 4");
    mSleep(math.random(11,36));
    os.execute("input keyevent 4") 
  end
  
end
