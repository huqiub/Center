--comment:登录状态下,向上滑屏1次，点击“推荐”按钮，随机点击1部视频播放，退出视频，向上滑屏1次，点击“动画”按钮，随机点击“月票榜”，“人气榜”，“打赏榜”按钮，随机播放2次动画，退出动画、退出xx榜，向上滑屏3次，退出应用。
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
  
  mSleep(math.random(4381, 5425));
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
  
  mSleep(math.random(3381, 4425));
  touchDown(0, 682, 1646);  --向上滑屏
  mSleep(90);
  touchMove(0, 670, 1605);
  mSleep(8);
  touchMove(0, 669, 1599);
  mSleep(8);
  touchMove(0, 668, 1595);
  mSleep(9);
  touchMove(0, 667, 1590);
  mSleep(18);
  touchMove(0, 666, 1575);
  mSleep(5);
  touchMove(0, 664, 1560);
  mSleep(59);
  touchMove(0, 666, 1503);
  mSleep(8);
  touchMove(0, 667, 1496);
  mSleep(8);
  touchMove(0, 669, 1485);
  mSleep(8);
  touchMove(0, 670, 1470);
  mSleep(8);
  touchMove(0, 672, 1458);
  mSleep(9);
  touchMove(0, 675, 1449);
  mSleep(9);
  touchMove(0, 677, 1441);
  mSleep(7);
  touchMove(0, 678, 1436);
  mSleep(10);
  touchMove(0, 680, 1430);
  mSleep(7);
  touchMove(0, 682, 1425);
  mSleep(9);
  touchMove(0, 683, 1419);
  mSleep(9);
  touchMove(0, 685, 1413);
  mSleep(8);
  touchMove(0, 687, 1406);
  mSleep(8);
  touchMove(0, 690, 1395);
  mSleep(8);
  touchMove(0, 692, 1383);
  mSleep(10);
  touchMove(0, 695, 1374);
  mSleep(7);
  touchMove(0, 697, 1366);
  mSleep(8);
  touchMove(0, 699, 1359);
  mSleep(9);
  touchMove(0, 701, 1353);
  mSleep(8);
  touchMove(0, 703, 1348);
  mSleep(8);
  touchMove(0, 705, 1344);
  mSleep(9);
  touchMove(0, 707, 1338);
  mSleep(8);
  touchMove(0, 709, 1335);
  mSleep(8);
  touchMove(0, 711, 1329);
  mSleep(9);
  touchMove(0, 714, 1323);
  mSleep(8);
  touchMove(0, 716, 1318);
  mSleep(8);
  touchMove(0, 719, 1310);
  mSleep(8);
  touchMove(0, 721, 1305);
  mSleep(8);
  touchMove(0, 723, 1297);
  mSleep(10);
  touchMove(0, 725, 1291);
  mSleep(8);
  touchMove(0, 726, 1288);
  mSleep(8);
  touchMove(0, 728, 1284);
  mSleep(9);
  touchMove(0, 729, 1278);
  mSleep(7);
  touchMove(0, 730, 1275);
  mSleep(10);
  touchMove(0, 733, 1271);
  mSleep(7);
  touchMove(0, 734, 1269);
  mSleep(8);
  touchMove(0, 735, 1265);
  mSleep(7);
  touchMove(0, 736, 1263);
  mSleep(8);
  touchMove(0, 737, 1261);
  mSleep(8);
  touchMove(0, 738, 1260);
  mSleep(17);
  touchMove(0, 739, 1256);
  mSleep(17);
  touchMove(0, 740, 1254);
  mSleep(17);
  touchMove(0, 741, 1252);
  mSleep(33);
  touchUp(0);
  
  mSleep(math.random(2272, 3091));
  touchDown(0, 98 + math.random(-23, 18), 73 + math.random(-26, 21));  -- 点击“动画”按钮
  mSleep(math.random(12, 41));
  touchUp(0);
  
  mSleep(math.random(3571, 4839));
  local j = math.random(1, 3);
  if j == 1 then
    touchDown(0, 144 + math.random(-43, 38), 688 + math.random(-32, 77)); -- 点击“月票榜”按钮
    mSleep(math.random(11, 36));
    touchUp(0);
  elseif j == 2 then
    touchDown(0, 411 + math.random(-41, 53), 688 + math.random(-32, 77)); -- 点击“人气榜”按钮
    mSleep(math.random(11, 36));
    touchUp(0);
  else
    touchDown(0, 676 + math.random(-51, 67), 688 + math.random(-32, 77)); -- 点击“打赏榜”按钮
    mSleep(math.random(11, 36));
    touchUp(0);
  end
  
  mSleep(math.random(2378, 3159));
  for x = 1, 2 do
    local k = math.random(1, 6);
    if k == 1 then
      touchDown(0, 711 + math.random(-470, 215), 360 + math.random(-93, 79));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    elseif k == 2 then
      touchDown(0, 711 + math.random(-470, 215), 656 + math.random(-93, 79));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    elseif k == 3 then
      touchDown(0, 711 + math.random(-470, 215), 950 + math.random(-93, 79));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    elseif k == 4 then
      touchDown(0, 711 + math.random(-470, 215), 1258 + math.random(-98, 79));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    elseif k == 5 then
      touchDown(0, 711 + math.random(-470, 215), 1552 + math.random(-98, 79));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    else
      touchDown(0, 711 + math.random(-470, 215), 1815 + math.random(-59, 43));  -- 点击动画
      mSleep(math.random(9, 29));
      touchUp(0);
    end
  mSleep(math.random(start, end));  -- 此处时间可以替换
  os.execute("input keyevent 4");
  mSleep(math.random(2398, 3219));
  end
  
  os.execute("input keyevent 4");
  
  mSleep(math.random(2427, 3682));
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
  
  mSleep(math.random(1846, 2611));
  os.execute("input keyevent 4");
  mSleep(math.random(11, 30));
  os.execute("input keyevent 4");
  mSleep(math.random(8, 23));
  os.execute("input keyevent 4");
  
end
