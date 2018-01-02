--comment:非登录状态下，点击“发现”按钮，向上滑屏2次，点击游戏栏目中的任意按钮，点击任意视频观看，退出视频，随机点击“最热”按钮切换成“最新”，点击任意视频观看，退出视频，退出游戏频道，退出应用。
-- 适用屏幕参数
SCREEN_RESOLUTION="1080x1920";
SCREEN_COLOR_BITS=32;

function exec(tab1)
  
  math.randomseed(tostring(os.time()):reverse():sub(1, 6));
  
  mSleep(math.random(5586, 6411));
  touchDown(0, 584, 853);  --向下滑屏
  mSleep(156);
  touchMove(0, 579, 898);
  mSleep(8);
  touchMove(0, 577, 909);
  mSleep(8);
  touchMove(0, 576, 920);
  mSleep(8);
  touchMove(0, 575, 933);
  mSleep(9);
  touchMove(0, 573, 946);
  mSleep(8);
  touchMove(0, 572, 958);
  mSleep(8);
  touchMove(0, 571, 967);
  mSleep(9);
  touchMove(0, 570, 978);
  mSleep(8);
  touchMove(0, 569, 990);
  mSleep(8);
  touchMove(0, 568, 1003);
  mSleep(9);
  touchMove(0, 567, 1016);
  mSleep(9);
  touchMove(0, 566, 1029);
  mSleep(17);
  touchMove(0, 565, 1051);
  mSleep(108);
  touchMove(0, 564, 1201);
  mSleep(17);
  touchMove(0, 563, 1218);
  mSleep(8);
  touchMove(0, 562, 1226);
  mSleep(17);
  touchMove(0, 561, 1248);
  mSleep(8);
  touchMove(0, 560, 1261);
  mSleep(10);
  touchMove(0, 558, 1273);
  mSleep(16);
  touchMove(0, 557, 1291);
  mSleep(8);
  touchMove(0, 556, 1301);
  mSleep(9);
  touchMove(0, 555, 1310);
  mSleep(17);
  touchMove(0, 554, 1335);
  mSleep(19);
  touchMove(0, 553, 1357);
  mSleep(109);
  touchMove(0, 555, 1477);
  mSleep(8);
  touchMove(0, 556, 1483);
  mSleep(17);
  touchMove(0, 557, 1500);
  mSleep(8);
  touchMove(0, 558, 1507);
  mSleep(25);
  touchMove(0, 560, 1524);
  mSleep(25);
  touchMove(0, 561, 1537);
  mSleep(17);
  touchMove(0, 562, 1543);
  mSleep(25);
  touchMove(0, 563, 1548);
  mSleep(42);
  touchMove(0, 564, 1556);
  mSleep(60);
  touchMove(0, 565, 1560);
  mSleep(14);
  touchUp(0);
  
  mSleep(math.random(3882, 4910));
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
  
  mSleep(math.random(3872, 4692));
  touchDown(0, 544 + math.random(-49, 54), 1816 + math.random(-35, 74));  --点击“发现”按钮
  mSleep(math.random(12, 25));
  touchUp(0);
  
  mSleep(math.random(2318, 3184));
  os.execute("input keyevent 4");  --点击Back键
  
  mSleep(math.random(3109, 4324));
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

  mSleep(math.random(1904, 2891));
  touchDown(0, 577, 1531);  --向上滑屏
  mSleep(81);
  touchMove(0, 581, 1423);
  mSleep(8);
  touchMove(0, 583, 1391);
  mSleep(8);
  touchMove(0, 584, 1370);
  mSleep(18);
  touchMove(0, 586, 1318);
  mSleep(7);
  touchMove(0, 588, 1291);
  mSleep(8);
  touchMove(0, 590, 1267);
  mSleep(8);
  touchMove(0, 592, 1231);
  mSleep(9);
  touchMove(0, 594, 1205);
  mSleep(8);
  touchMove(0, 596, 1177);
  mSleep(8);
  touchMove(0, 601, 1140);
  mSleep(8);
  touchMove(0, 604, 1115);
  mSleep(9);
  touchMove(0, 609, 1081);
  mSleep(8);
  touchMove(0, 614, 1053);
  mSleep(8);
  touchMove(0, 620, 1029);
  mSleep(7);
  touchMove(0, 627, 995);
  mSleep(8);
  touchMove(0, 631, 973);
  mSleep(8);
  touchMove(0, 634, 956);
  mSleep(8);
  touchMove(0, 639, 937);
  mSleep(9);
  touchMove(0, 644, 913);
  mSleep(8);
  touchMove(0, 648, 896);
  mSleep(8);
  touchMove(0, 650, 881);
  mSleep(9);
  touchMove(0, 653, 868);
  mSleep(8);
  touchMove(0, 657, 855);
  mSleep(8);
  touchMove(0, 660, 841);
  mSleep(9);
  touchMove(0, 662, 830);
  mSleep(8);
  touchMove(0, 665, 817);
  mSleep(9);
  touchMove(0, 668, 808);
  mSleep(9);
  touchMove(0, 671, 796);
  mSleep(8);
  touchMove(0, 675, 787);
  mSleep(9);
  touchMove(0, 678, 780);
  mSleep(8);
  touchMove(0, 680, 772);
  mSleep(9);
  touchMove(0, 684, 763);
  mSleep(8);
  touchMove(0, 687, 751);
  mSleep(9);
  touchMove(0, 691, 740);
  mSleep(8);
  touchMove(0, 696, 731);
  mSleep(8);
  touchMove(0, 699, 723);
  mSleep(9);
  touchMove(0, 702, 718);
  mSleep(9);
  touchMove(0, 705, 710);
  mSleep(8);
  touchMove(0, 707, 705);
  mSleep(9);
  touchMove(0, 710, 699);
  mSleep(8);
  touchMove(0, 714, 693);
  mSleep(8);
  touchMove(0, 717, 688);
  mSleep(9);
  touchMove(0, 720, 682);
  mSleep(8);
  touchMove(0, 723, 676);
  mSleep(8);
  touchMove(0, 726, 669);
  mSleep(8);
  touchMove(0, 729, 663);
  mSleep(8);
  touchMove(0, 733, 658);
  mSleep(9);
  touchMove(0, 736, 652);
  mSleep(7);
  touchMove(0, 738, 646);
  mSleep(9);
  touchMove(0, 741, 641);
  mSleep(7);
  touchMove(0, 743, 637);
  mSleep(12);
  touchMove(0, 745, 633);
  mSleep(5);
  touchMove(0, 746, 630);
  mSleep(9);
  touchMove(0, 748, 626);
  mSleep(8);
  touchMove(0, 750, 622);
  mSleep(9);
  touchMove(0, 753, 620);
  mSleep(8);
  touchMove(0, 754, 616);
  mSleep(9);
  touchMove(0, 756, 615);
  mSleep(8);
  touchMove(0, 757, 613);
  mSleep(8);
  touchMove(0, 759, 609);
  mSleep(8);
  touchMove(0, 760, 607);
  mSleep(8);
  touchMove(0, 761, 605);
  mSleep(8);
  touchMove(0, 762, 603);
  mSleep(17);
  touchMove(0, 764, 601);
  mSleep(9);
  touchMove(0, 765, 600);
  mSleep(18);
  touchMove(0, 767, 598);
  mSleep(16);
  touchUp(0);
  
  mSleep(math.random(2145, 2965));
  if 1 == math.random(1, 2) then
    touchDown(0, 552 + math.random(-422, 418), 1059 + math.random(-37, 43));  --点击选项
    mSleep(12, 37);
    touchUp(0);
  else
    touchDown(0, 552 + math.random(-422, 115), 1185 + math.random(-37, 45));  --点击选项
    mSleep(12, 37);
    touchUp(0);
  end
  
  mSleep(math.random(2249, 3176));
  touchDown(0, 551 + math.random(-324, 235), 144 + math.random(-39, 41));  --点击屏幕跳过引导
  mSleep(math.random(9, 21));
  touchUp(0);
  
  mSleep(math.random(2967, 3892));
  touchDown(0, 436 + math.random(-364, 464), 841 + math.random(-410, 969));  --点击任意视频
  mSleep(math.random(9, 26));
  touchUp(0);
  
  mSleep(math.random(start, end));  --此处时间可以替换
  os.execute("input keyevent 4");  --退出视频
  
  local j = math.random(1, 2);
  if j == 1 then
    mSleep(math.random(2089, 3398));
    touchDown(0, 989 + math.random(-68, 54), 144 + math.random(-13, 32));  --点击“最热”按钮
    mSleep(math.random(9, 26));
    touchUp(0);
    
    mSleep(math.random(1967, 2798));
    touchDown(0, 981 + math.random(-56, 72 ), 408 + math.random(-50, 36));  --点击“最新”按钮
    mSleep(math.random(9, 26));
    touchUp(0);
    
    mSleep(math.random(3871, 4991));
    touchDown(0, 436 + math.random(-364, 464), 841 + math.random(-410, 969));  --点击任意视频
    mSleep(math.random(9, 26));
    touchUp(0);
  else
    mSleep(math.random(3289, 4696));
    touchDown(0, 436 + math.random(-364, 464), 841 + math.random(-410, 969));  --点击任意视频
    mSleep(math.random(9, 26));
    touchUp(0);
  end
  
  mSleep(math.random(start, end));  --此处时间可以替换
  os.execute("input keyevent 4");  --退出视频
  
  mSleep(math.random(1867, 2516));
  os.execute("input keyevent 4");  --退出选项
  
  mSleep(math.random(2876, 3786));
  os.execute("input keyevent 4");  --退出应用
  mSleep(math.random(13, 34));
  os.execute("input keyevent 4");
  mSleep(math.random(11, 29));
  os.execute("input keyevent 4");
  
end
