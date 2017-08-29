public final class ItemDef {

	public static void nullLoader() {
		mruNodes2 = null;
		mruNodes1 = null;
		streamIndices = null;
		cache = null;
		stream = null;
	}


	public boolean method192(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		return flag;
	}

	public static void unpackConfig(StreamLoader archive) {
		stream = new Stream(archive.getDataForName("obj.dat"));
		Stream stream = new Stream(archive.getDataForName("obj.idx"));
		totalItems = stream.readUnsignedWord() + 21;
		streamIndices = new int[totalItems + 50000];
		int i = 2;
		for (int j = 0; j < totalItems - 21; j++) {
			streamIndices[j] = i;
			i += stream.readUnsignedWord();
		}

		cache = new ItemDef[10];
		for (int k = 0; k < 10; k++)
			cache[k] = new ItemDef();

	}

	public Model method194(int j) {
		int k = anInt175;
		int l = anInt166;
		if (j == 1) {
			k = anInt197;
			l = anInt173;
		}
		if (k == -1)
			return null;
		Model model = Model.method462(k);
		if (l != -1) {
			Model model_1 = Model.method462(l);
			Model aclass30_sub2_sub4_sub6s[] = { model, model_1 };
			model = new Model(2, aclass30_sub2_sub4_sub6s);
		}
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
				model.method476(modifiedModelColors[i1],
						originalModelColors[i1]);

		}
		return model;
	}

	public boolean method195(int j) {
		int k = anInt165;
		int l = anInt188;
		int i1 = anInt185;
		if (j == 1) {
			k = anInt200;
			l = anInt164;
			i1 = anInt162;
		}
		if (k == -1)
			return true;
		boolean flag = true;
		if (!Model.method463(k))
			flag = false;
		if (l != -1 && !Model.method463(l))
			flag = false;
		if (i1 != -1 && !Model.method463(i1))
			flag = false;
		return flag;
	}

	public Model method196(int i) {
		int j = anInt165;
		int k = anInt188;
		int l = anInt185;
		if (i == 1) {
			j = anInt200;
			k = anInt164;
			l = anInt162;
		}
		if (j == -1)
			return null;
		Model model = Model.method462(j);
		if (k != -1)
			if (l != -1) {
				Model model_1 = Model.method462(k);
				Model model_3 = Model.method462(l);
				Model aclass30_sub2_sub4_sub6_1s[] = { model, model_1, model_3 };
				model = new Model(3, aclass30_sub2_sub4_sub6_1s);
			} else {
				Model model_2 = Model.method462(k);
				Model aclass30_sub2_sub4_sub6s[] = { model, model_2 };
				model = new Model(2, aclass30_sub2_sub4_sub6s);
			}
		if (i == 0 && aByte205 != 0)
			model.method475(0, aByte205, 0);
		if (i == 1 && aByte154 != 0)
			model.method475(0, aByte154, 0);
		if (modifiedModelColors != null) {
			for (int i1 = 0; i1 < modifiedModelColors.length; i1++)
				model.method476(modifiedModelColors[i1],
						originalModelColors[i1]);

		}
		return model;
	}
	
	private void setDefaults() {
		modelID = 0;
		femaleEquipOffset = 0;
		name = null;
		description = null;
		modifiedModelColors = null;
		originalModelColors = null;
		modelZoom = 2000;
		modelRotationY = 0;
		modelRotationX = 0;
		anInt204 = 0;
		modelOffset1 = 0;
		modelOffset2 = 0;
		stackable = false;
		value = 1;
		membersObject = false;
		groundActions = null;
		itemActions = null;
		anInt165 = -1;
		anInt188 = -1;
		aByte205 = 0;
		anInt200 = -1;
		anInt164 = -1;
		aByte154 = 0;
		anInt185 = -1;
		anInt162 = -1;
		anInt175 = -1;
		anInt166 = -1;
		anInt197 = -1;
		anInt173 = -1;
		stackIDs = null;
		stackAmounts = null;
		certID = -1;
		certTemplateID = -1;
		anInt167 = 128;
		anInt192 = 128;
		anInt191 = 128;
		anInt196 = 0;
		anInt184 = 0;
		team = 0;
	}


	public static ItemDef forID(int i) {
		for (int j = 0; j < 10; j++)
			if (cache[j].id == i)
				return cache[j];

		cacheIndex = (cacheIndex + 1) % 10;
		ItemDef itemDef = cache[cacheIndex];
		stream.currentOffset = streamIndices[i];
		itemDef.id = i;
		itemDef.setDefaults();
		itemDef.readValues(stream);
		if (itemDef.modifiedModelColors != null) {
			for (int i2 = 0; i2 < itemDef.modifiedModelColors.length; i2++) {
				if (itemDef.originalModelColors[i2] == 0) {
					itemDef.originalModelColors[i2] = 1;
				}
			}
		}
		if (itemDef.id == i && itemDef.modifiedModelColors == null) {
			itemDef.modifiedModelColors = new int [1];
			itemDef.originalModelColors = new int [1];
			itemDef.modifiedModelColors[0] = 0;
			itemDef.originalModelColors[0] = 1;
		}
		switch (i) {
			
		case 2704:
		case 2701:
			itemDef.name = "Clue Scroll (Easy)";
		break;
		
		case 2697:
		case 2693:
		case 2690:
			itemDef.name = "Clue Scroll (Medium)";
		break;
		
		case 2713:
		case 2710:
		case 2707:
			itemDef.name = "Clue Scroll (Hard)";
		break;
		
		
		case 2680:
			itemDef.name = "Clue Scroll @or1@(Elite)";
			break;
			
		case 15570:
			itemDef.name = "Verac Jr";
			itemDef.modelID = 6678;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		
		case 15568:
			itemDef.name = "Ahrim Jr";
			itemDef.modelID = 6668;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		case 15566:
			itemDef.name = "Dharok Jr";
			itemDef.modelID = 6671;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		case 15564:
			itemDef.name = "Guthan Jr";
			itemDef.modelID = 6674;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		case 15562:
			itemDef.name = "Karil Jr";
			itemDef.modelID = 6675;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		case 15560:
			itemDef.name = "Torag Jr";
			itemDef.modelID = 6677;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
		break;
		case 15571:
			itemDef.name = "Venenatis Jr";
			itemDef.modelID = 28294;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			break;
		case 15572:
			itemDef.name = "Scorpia Jr";
			itemDef.modelID = 28293;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			break;
			
		case 15573:
			itemDef.name = "Callisto Jr";
			itemDef.modelID = 28298;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			break;
			
		case 15574:
			itemDef.name = "Vet'ion Jr";
			itemDef.modelID = 28299;
			itemDef.modelRotationY = 0;
			itemDef.modelRotationX = 0;
			itemDef.modelZoom = 3000;
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			break;
			
		case 14613:
			itemDef.name = "Serpentine helm";
			itemDef.modelZoom = 700;
			itemDef.modelRotationY = 215;
			itemDef.modelRotationX = 1724;
			itemDef.modelOffset2 = -17;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", "Check", null, "Drop" };
			itemDef.modelID = 19220;
			itemDef.anInt165 = 14395;
			itemDef.anInt200 = 14398;
		break;
		
		case 12954:
			itemDef.name = "Dragon defender";
			itemDef.modelZoom = 589;
			itemDef.modelRotationY = 498;
			itemDef.modelRotationX = 256;
			itemDef.modelOffset2 = 8;
			itemDef.modelOffset1 = 8;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.modelID = 10422;
			itemDef.anInt165 = 10420;
			itemDef.anInt200 = 10421;
		break;
			
		case 13868:
			itemDef.name = "Achievement Diary Hood";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wield";
			itemDef.modelID = 19058;
			itemDef.modelZoom = 720;
			itemDef.modelRotationY = 21;
			itemDef.modelRotationX = 18;
			itemDef.originalModelColors = new int[] { -22440, -22423, -22427, 21619, 21733, 21733 };
			itemDef.modifiedModelColors = new int[] { -8256, -11353, -11033, 960, 22464, -21568 };
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = 1;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 18914;
		    itemDef.anInt200 = 18967;
			itemDef.description = "An Achievement Diary Hood.".getBytes();
		break;
		
		case 12899:
			itemDef.name = "Trident of the swamp";
			itemDef.modelZoom = 2421;
			itemDef.modelRotationY = 1549;
			itemDef.modelRotationX = 1818;
			itemDef.modelOffset2 = 9;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", "Check", "Uncharge", "Drop" };
			itemDef.modelID = 19223;
			itemDef.anInt165 = 14400;
			itemDef.anInt200 = 14400;
		break;

		case 12904:
			itemDef.name = "Toxic staff of the dead";
			itemDef.modelZoom = 2150;
			itemDef.modelRotationY = 512;
			itemDef.modelRotationX = 1010;
			//itemDef.destItemColors = new int[] { 21947 };
			//itemDef.srcItemColors = new int[] { 17467 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", "Check", null, "Drop" };
			itemDef.modelID = 19224;
			itemDef.anInt165 = 14402;
			itemDef.anInt200 = 14402;
		break;
		
		case 13069:
					itemDef.itemActions = new String[5];
        			itemDef.itemActions[1] = "Wear";
        			itemDef.modelID = 10481;
        			itemDef.modelZoom = 2128;
        			itemDef.modelRotationY = 504;
        			itemDef.modelRotationX = 0;
        			itemDef.modelOffset1 = 0;
        			itemDef.modelOffset2 = 1;
        			itemDef.anInt204 = 0;
        			itemDef.anInt165 = 28203;
					itemDef.anInt200 = 29051;
					itemDef.name = "Achievement Diary Cape (t)";
					itemDef.description = "Achievement Diary Cape (t)".getBytes();
        			itemDef.anInt175 = -1;
        			itemDef.anInt197 = -1;
		break;
				
			
				
				
			case 19010:
				itemDef.modelID = 65270;
				itemDef.name = "Completionist cape";
				itemDef.description = "Completionist cape".getBytes();
				itemDef.modelZoom = 1385;
				itemDef.modelOffset1 = 0;
				itemDef.modelOffset2 = 24;
				itemDef.modelRotationY = 279;
				itemDef.modelRotationX = 948;
				itemDef.anInt165 = 65297;
				itemDef.anInt200 = 65297;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
		break;		
		case 19009:
				itemDef.modelID = 65262;
				itemDef.name = "Max cape";
				itemDef.description = "Max cape".getBytes();
				itemDef.modelZoom = 1385;
				itemDef.modelOffset1 = 0;
				itemDef.modelOffset2 = 24;
				itemDef.modelRotationY = 279;
				itemDef.modelRotationX = 948;
				itemDef.anInt165 = 65300;
				itemDef.anInt200 = 65322;
				itemDef.groundActions = new String[5];
				itemDef.groundActions[2] = "Take";
				itemDef.itemActions = new String[5];
				itemDef.itemActions[1] = "Wear";
			break;
			
			case 12922:
				itemDef.name = "Tanzanite fang";
				itemDef.modelZoom = 1411;
				itemDef.modelRotationY = 202;
				itemDef.modelRotationX = 1939;
				itemDef.modelOffset1 = -4;
				itemDef.modelOffset2 = -8;
				itemDef.groundActions = new String[] { null, null, "Take", null, null };
				itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
				itemDef.modelID = 19228;
			break;
			
			case 12927:
				itemDef.name = "Serpentine visage";
				itemDef.modelZoom = 716;
				itemDef.modelRotationY = 498;
				itemDef.modelOffset1 = -18;
				itemDef.modelOffset2 = 7;
				itemDef.groundActions = new String[] { null, null, "Take", null, null };
				itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
				itemDef.modelID = 19218;
			break;
			
			case 12932:
				itemDef.name = "Magic fang";
				itemDef.modelZoom = 1095;
				itemDef.modelRotationY = 579;
				itemDef.modelRotationX = 1832;
				itemDef.modelOffset1 = 7;
				itemDef.groundActions = new String[] { null, null, "Take", null, null };
				itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
				itemDef.modelID = 19227;
			break;

			case 12934:
				itemDef.name = "Zulrah's scales";
				itemDef.modelZoom = 1370;
				itemDef.modelRotationY = 212;
				itemDef.modelRotationX = 148;
				itemDef.modelOffset1 = 7;
				itemDef.groundActions = new String[] { null, null, "Take", null, null };
				itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
				itemDef.modelID = 19212;
			break;

			
			
		  case 12926:
		    	itemDef.modelID = 25000;
		    	itemDef.name = "Toxic blowpipe";
		    	itemDef.description = "It's a Toxic blowpipe".getBytes();
		    	itemDef.modelZoom = 1158;
		    	itemDef.modelRotationY = 768;
		    	itemDef.modelRotationX = 189;
		    	itemDef.modelOffset1 = -7;
		    	itemDef.modelOffset2 = 4;
		    	itemDef.anInt165 = 14403;
		    	itemDef.anInt200 = 14403;
		    	itemDef.aByte154 = 6;
		    	itemDef.itemActions = new String[] { null, "Wield", "Check", "Unload", "Drop" };
		    	itemDef.groundActions = new String[] { null, null, "Take", null, null };
		    break;
		case 12773:
			itemDef.name = "Volcanic abyssal whip";
			itemDef.modelZoom = 840;
			itemDef.modelRotationY = 280;
			itemDef.modelOffset1 = -2;
			itemDef.modelOffset2 = 56;
			itemDef.modifiedModelColors = new int[1];
			itemDef.originalModelColors = new int[1];
			itemDef.modifiedModelColors[0] = 528;
			itemDef.originalModelColors[0] = 5056;
			//itemDef.destItemColors = new int[] { 5056 };
			//itemDef.srcItemColors = new int[] { 528 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.modelID = 5455;
			itemDef.anInt165 = 8950;
			itemDef.anInt200 = 8950;
			break;
		case 12601:
			itemDef.name = "Ring of the gods";
			itemDef.modelZoom = 900;
			itemDef.modelRotationY = 393;
			itemDef.modelRotationX = 1589;
			itemDef.modelOffset1 = -9;
			itemDef.modelOffset2 = -12;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.modelID = 28824;
			break;

		case 12603:
			itemDef.name = "Tyrannical ring";
			itemDef.modelZoom = 592;
			itemDef.modelRotationY = 285;
			itemDef.modelRotationX = 1163;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.modelID = 28823;
			break;

		case 12605:
			itemDef.name = "Treasonous ring";
			itemDef.modelZoom = 750;
			itemDef.modelRotationY = 342;
			itemDef.modelRotationX = 252;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -12;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.modelID = 28825;
			break;
		case 11995:
			itemDef.name = "Pet chaos elemental";
			itemDef.modelZoom = 1284;
			itemDef.modelRotationX = 175;
			itemDef.modelOffset1 = -66;
			itemDef.modelOffset2 = 75;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28256;
			break;
		
		/*case 12795:
			itemDef.name = "Steam battlestaff";
			itemDef.modelZoom = 1158;
			itemDef.modelRotationY = 364;
			itemDef.modelRotationX = 1252;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -9;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", null, null, "Revert" };
			itemDef.modelID = 9599;
			itemDef.anInt165 = 8964;
			itemDef.anInt200 = 8964;
			break;*/

		case 12796:
			itemDef.name = "Mystic steam staff";
			itemDef.modelZoom = 1158;
			itemDef.modelRotationY = 364;
			itemDef.modelRotationX = 1252;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = -9;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", null, null, "Revert" };
			itemDef.modelID = 9599;
			itemDef.anInt165 = 8964;
			itemDef.anInt200 = 8964;
			break;
		case 12703:
			itemDef.name = "Pet penance queen";
			itemDef.modelZoom = 8358;
			itemDef.modelRotationX = 81;
			itemDef.modelOffset1 = 17;
			itemDef.modelOffset2 = 33;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 20711;
			break;
		case 12693:
			itemDef.name = "Kree'arra";
			itemDef.modelZoom = 10000;
			itemDef.modelRotationY = 431;
			itemDef.modelRotationX = 377;
			itemDef.modelOffset1 = 46;
			itemDef.modelOffset2 = -47;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28019;
			break;

		case 12694:
			itemDef.name = "Pet Chaos elemental";
			itemDef.modelZoom = 5326;
			itemDef.modelRotationY = 189;
			itemDef.modelRotationX = 175;
			itemDef.modelOffset1 = -17;
			itemDef.modelOffset2 = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 11216;
			break;
		case 12691:
			itemDef.name = "Tyrannical ring (i)";
			itemDef.modelZoom = 592;
			itemDef.modelRotationY = 285;
			itemDef.modelRotationX = 1163;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", "Uncharge", null, "Drop" };
			itemDef.modelID = 28823;
			break;

		case 12692:
			itemDef.name = "Treasonous ring (i)";
			itemDef.modelZoom = 750;
			itemDef.modelRotationY = 342;
			itemDef.modelRotationX = 252;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -12;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", "Uncharge", null, "Drop" };
			itemDef.modelID = 28825;
			break;
		case 12643:
			itemDef.name = "Pet dagannoth supreme";
			itemDef.modelZoom = 4560;
			itemDef.modelRotationY = 2042;
			itemDef.modelRotationX = 1868;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 9941;
			break;

		case 12644:
			itemDef.name = "Pet dagannoth prime";
			itemDef.modelZoom = 4560;
			itemDef.modelRotationY = 2042;
			itemDef.modelRotationX = 1868;
			itemDef.modifiedModelColors = new int[4];
			itemDef.originalModelColors = new int[4];
			itemDef.originalModelColors[0] = 5931;
			itemDef.modifiedModelColors[0] = 11930;
			itemDef.originalModelColors[1] = 1688;
			itemDef.modifiedModelColors[1] = 27144;
			itemDef.originalModelColors[2] = 21530;
			itemDef.modifiedModelColors[2] = 16536;
			itemDef.originalModelColors[3] = 21534;
			itemDef.modifiedModelColors[3] = 16540;
			//itemDef.destItemColors = new int[] { 5931, 1688, 21530, 21534 };
			//itemDef.srcItemColors = new int[] { 11930, 27144, 16536, 16540 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 9941;
			break;

		case 12645:
			itemDef.name = "Pet dagannoth rex";
			itemDef.modelZoom = 4560;
			itemDef.modelRotationY = 2042;
			itemDef.modelRotationX = 1868;
			itemDef.modifiedModelColors = new int[4];
			itemDef.originalModelColors = new int[4];
			itemDef.originalModelColors[0] = 7322;
			itemDef.modifiedModelColors[0] = 16536;
			itemDef.originalModelColors[1] = 7326;
			itemDef.modifiedModelColors[1] = 16540;
			itemDef.originalModelColors[2] = 10403;
			itemDef.modifiedModelColors[2] = 27144;
			itemDef.originalModelColors[3] = 2595;
			itemDef.modifiedModelColors[3] = 2477;
			//itemDef.destItemColors = new int[] { 7322, 7326, 10403, 2595 };
			//itemDef.srcItemColors = new int[] { 16536, 16540, 27144, 2477 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 9941;
			break;

		case 12646:
			itemDef.name = "Baby mole";
			itemDef.modelZoom = 2256;
			itemDef.modelRotationY = 369;
			itemDef.modelRotationX = 1874;
			itemDef.modelOffset2 = 20;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 12073;
			break;

		case 12647:
			itemDef.name = "Kalphite princess";
			itemDef.modelZoom = 8016;
			itemDef.modelRotationY = 342;
			itemDef.modelRotationX = 1778;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 24597;
			break;

		case 12648:
			itemDef.name = "Pet smoke devil";
			itemDef.modelZoom = 3984;
			itemDef.modelRotationY = 9;
			itemDef.modelRotationX = 1862;
			itemDef.modelOffset2 = 20;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28442;
			break;

		case 12649:
			itemDef.name = "Pet kree'arra";
			itemDef.modelZoom = 976;
			itemDef.modelRotationY = 2042;
			itemDef.modelRotationX = 1892;
			itemDef.modelOffset1 = -20;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28873;
			break;

		case 12650:
			itemDef.name = "Pet general graardor";
			itemDef.modelZoom = 1872;
			itemDef.modelOffset1 = -3;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28874;
			break;

		case 12651:
			itemDef.name = "Pet zilyana";
			itemDef.modelZoom = 1000;
			itemDef.modelRotationY = 9;
			itemDef.modelRotationX = 1931;
			itemDef.modelOffset1 = 5;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28870;
			break;

		case 12652:
			itemDef.name = "Pet k'ril tsutsaroth";
			itemDef.modelZoom = 1168;
			itemDef.modelRotationY = 2012;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28868;
			break;

		case 12653:
			itemDef.name = "Prince black dragon";
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28872;
			break;

		case 12654:
			itemDef.name = "Kalphite princess";
			itemDef.modelZoom = 740;
			itemDef.modelRotationY = 279;
			itemDef.modelRotationX = 1808;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28871;
			break;

		case 12655:
			itemDef.name = "Pet kraken";
			itemDef.modelZoom = 1744;
			itemDef.modelRotationY = 330;
			itemDef.modelRotationX = 1940;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, null, null, null, "Drop" };
			itemDef.modelID = 28869;
			break;
		case 12371:
			itemDef.name = "Lava dragon mask";
			itemDef.modelZoom = 905;
			itemDef.modelRotationY = 202;
			itemDef.modelRotationX = 121;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset2 = 22;
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
			itemDef.modelID = 28714;
			itemDef.anInt165 = 28512;
			itemDef.anInt200 = 28581;
			break;
		case 12389:
			itemDef.name = "Gilded scimitar";
			itemDef.modelZoom = 1180;
			itemDef.modelRotationY = 300;
			itemDef.modelRotationX = 1120;
			itemDef.modelOffset1 = -6;
			itemDef.modelOffset2 = 4;
			itemDef.modifiedModelColors = new int[1];
			itemDef.originalModelColors = new int[1];
			itemDef.originalModelColors[0] = 7144;
			itemDef.modifiedModelColors[0] = 61;
			//itemDef.destItemColors = new int[] { 7114 };
			//itemDef.srcItemColors = new int[] { 61 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
			itemDef.modelID = 2373;
			itemDef.anInt165 = 490;
			itemDef.anInt200 = 490;
			break;
				case 12424:
					itemDef.name = "3rd age bow";
					itemDef.modelZoom = 1979;
					itemDef.modelRotationY = 537;
					itemDef.modelRotationX = 256;
					itemDef.modelOffset1 = -15;
					itemDef.modelOffset2 = 10;
					itemDef.groundActions = new String[] { null, null, "Take", null, null };
					itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
					itemDef.modelID = 28678;
					itemDef.anInt165 = 28622;
					itemDef.anInt200 = 28622;
					break;
		case 11847:
			itemDef.name = "Black h'ween mask";
			itemDef.modelZoom = 730;
			itemDef.modelRotationY = 516;
			itemDef.modelOffset2 = -10;
			itemDef.modifiedModelColors = new int[2];
			itemDef.originalModelColors = new int[2];
			itemDef.originalModelColors[0] = 8;
			itemDef.modifiedModelColors[0] = 926;
			itemDef.originalModelColors[1] = 9152;
			itemDef.modifiedModelColors[1] = 0;
			//itemDef.destItemColors = new int[] { 8, 9152 };
			//itemDef.srcItemColors = new int[] { 926, 0 };
			itemDef.groundActions = new String[] { null, null, "Take", null, null };
			itemDef.itemActions = new String[] { null, "Wear", null, null, "Destroy" };
			itemDef.modelID = 2438;
			itemDef.anInt165 = 3188;
			itemDef.anInt200 = 3192;
			break; 
			
			/*
			*
			*Emblems
			*/
			
			case 12746:
			itemDef.name = "@gre@Mysterious emblem";
			itemDef.modelZoom = 1221;
			itemDef.modelRotationX = 2047;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = -1;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 3677;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12748:
			itemDef.name = "@gre@Mysterious emblem (tier 2)";
			itemDef.modelZoom = 1032;
			itemDef.modelRotationX = 1912;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modelOffset1 = -1;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 3680;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12749:
			itemDef.name = "@gre@Mysterious emblem (tier 3)";
			itemDef.modelZoom = 968;
			itemDef.modelRotationX = 1926;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset1 = -4;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 5446;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12750:
			itemDef.name = "@gre@Mysterious emblem (tier 4)";
			itemDef.modelZoom = 1032;
			itemDef.modelRotationX = 202;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset1 = -4;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 3676;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12751:
			itemDef.name = "@gre@Mysterious emblem (tier 5)";
			itemDef.modelZoom = 1221;
			itemDef.modelRotationY = 13;
			itemDef.modelRotationX = 54;
			itemDef.modelOffset2 = -1;
			itemDef.modelOffset1 = -1;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 5448;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12752:
			itemDef.name = "@gre@Mysterious emblem (tier 6)";
			itemDef.modelZoom = 1221;
			itemDef.modelRotationX = 202;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset2 = -1;
			itemDef.modelOffset1 = -1;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 5447;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12753:
			itemDef.name = "@gre@Mysterious emblem (tier 7)";
			itemDef.modelZoom = 1221;
			itemDef.modelRotationX = 0;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset2 = -4;
			itemDef.modelOffset1 = -5;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 3678;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12754:
			itemDef.name = "@gre@Mysterious emblem (tier 8)";
			itemDef.modelZoom = 1411;
			itemDef.modelRotationX = 0;
			itemDef.modelRotationY = 0;
			itemDef.modelOffset2 = -5;
			itemDef.modelOffset1 = -4;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 5444;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12755:
			itemDef.name = "@gre@Mysterious emblem (tier 9)";
			itemDef.modelZoom = 1284;
			itemDef.modelRotationY = 135;
			itemDef.modelOffset1 = -1;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 3679;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;

		case 12756:
			itemDef.name = "@gre@Mysterious emblem (tier 10)";
			itemDef.modelZoom = 1600;
			itemDef.modelRotationY = 121;
			itemDef.modelRotationX = 108;
			itemDef.modelOffset2 = 3;
			itemDef.modelOffset1 = -9;
			itemDef.itemActions = new String[] { null, null, null, null,
					"Destroy" };
			itemDef.modelID = 5445;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;
				
				
				case 11862:
					itemDef.name = "Black partyhat";
					itemDef.modelZoom = 440;
					itemDef.modelRotationY = 76;
					itemDef.modelRotationX = 1852;
					itemDef.modelOffset1 = 1;
					itemDef.modelOffset2 = 1;
					itemDef.modifiedModelColors = new int[1];
					itemDef.originalModelColors = new int[1];
					itemDef.modifiedModelColors[0] = 926;
					itemDef.originalModelColors[0] = 0;
					//itemDef.destItemColors = new int[] { 0 };
					//itemDef.srcItemColors = new int[] { 926 };
					itemDef.groundActions = new String[] { null, null, "Take", null, null };
					itemDef.itemActions = new String[] { null, "Wear", null, null, "Destroy" };
					itemDef.modelID = 2635;
					itemDef.anInt165 = 187;
					itemDef.anInt200 = 363;
					break;

				case 11863:
					itemDef.name = "Rainbow partyhat";
					itemDef.modelZoom = 440;
					itemDef.modelRotationY = 76;
					itemDef.modelRotationX = 1852;
					itemDef.modelOffset1 = 1;
					itemDef.modelOffset2 = 1;
					itemDef.groundActions = new String[] { null, null, "Take", null, null };
					itemDef.itemActions = new String[] { null, "Wear", null, null, "Destroy" };
					itemDef.modelID = 16252;
					itemDef.anInt165 = 16246;
					itemDef.anInt200 = 16248;
					break;
				case 12422:
					itemDef.name = "3rd age wand";
					itemDef.modelZoom = 1347;
					itemDef.modelRotationY = 1468;
					itemDef.modelRotationX = 1805;
					itemDef.modelOffset2 = 1;
					itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
					itemDef.modelID = 28654;
					itemDef.anInt165 = 28619;
					itemDef.anInt200 = 28619;
					break;

				case 12426:
					itemDef.name = "3rd age longsword";
					itemDef.modelZoom = 1726;
					itemDef.modelRotationY = 1576;
					itemDef.modelRotationX = 242;
					itemDef.modelOffset1 = 5;
					itemDef.modelOffset2 = 4;
					itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
					itemDef.modelID = 28633;
					itemDef.anInt165 = 28618;
					itemDef.anInt200 = 28618;
					break;
				case 12391:
					itemDef.name = "Gilded boots";
					itemDef.modelZoom = 770;
					itemDef.modelRotationY = 164;
					itemDef.modelRotationX = 156;
					itemDef.modelOffset1 = 3;
					itemDef.modelOffset2 = -3;
					//itemDef.destItemColors = new int[] { 7114, 7104 };
					//itemDef.srcItemColors = new int[] { 61, 5400 };
					itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
					itemDef.modelID = 5037;
					itemDef.anInt165 = 4954;
					itemDef.anInt200 = 5031;
					break;
				case 12399:
					itemDef.name = "Partyhat & specs";
					itemDef.modelZoom = 653;
					itemDef.modelRotationX = 0;
					itemDef.modelRotationY = 242;
					itemDef.modelOffset1 = -1;
					itemDef.modelOffset2 = -59;
					itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
					itemDef.modelID = 28693;
					itemDef.anInt165 = 28505;
					itemDef.anInt200 = 28576;
					break;
				case 12002:
					itemDef.name = "Occult necklace";
					itemDef.modelZoom = 589;
					itemDef.modelRotationY = 431;
					itemDef.modelRotationX = 81;
					itemDef.modelOffset1 = 3;
					itemDef.modelOffset2 = 19;
					itemDef.itemActions = new String[] { null, "Wear", null, null, "Drop" };
					itemDef.modelID = 28438;
					itemDef.anInt165 = 28445;
					itemDef.anInt200 = 28445;
					break;

				case 11791:
					itemDef.name = "Staff of the dead";
				       itemDef.itemActions = new String[5];
				       itemDef.itemActions[1] = "Wield";
				       itemDef.description = "A ghastly weapon with evil origins.".getBytes();
					   itemDef.modifiedModelColors = new int [3];
					itemDef.originalModelColors = new int [3];
					itemDef.modifiedModelColors[0] = 15009;
					itemDef.originalModelColors[0] = 35489;
					itemDef.modifiedModelColors[1] = 17294;
					itemDef.originalModelColors[1] = 37774;
					itemDef.modifiedModelColors[2] = 15252;
					itemDef.originalModelColors[2] = 35732;
				       itemDef.modelID = 2810;
				       itemDef.anInt165 = 5232;
				       itemDef.anInt200 = 5232;
				       itemDef.modelRotationY = 148;
				       itemDef.modelRotationX = 1300;
				       itemDef.modelZoom = 1420;
				       itemDef.modelOffset1 = -5;
				       itemDef.modelOffset2 = 2;
					break;
				case 11889:
					itemDef.name = "Zamorakian hasta";
					itemDef.modelZoom = 1900;
					itemDef.modelRotationY = 1257;
					itemDef.modelRotationX = 512;
					itemDef.modelOffset1 = 4;
					itemDef.modelOffset2 = -4;
					//itemDef.destItemColors = new int[] { 41 };
					//itemDef.srcItemColors = new int[] { 78 };
					itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
					itemDef.modelID = 28038;
					itemDef.anInt165 = 27654;
					itemDef.anInt200 = 27654;
					break;
				
				case 11785:
					itemDef.name = "Armadyl crossbow";
					itemDef.modelZoom = 1325;
					itemDef.modelRotationY = 240;
					itemDef.modelRotationX = 110;
					itemDef.modelOffset1 = -4;
					itemDef.modelOffset2 = -40;
					itemDef.modifiedModelColors = new int[4];
					itemDef.originalModelColors = new int[4];
					itemDef.originalModelColors[0] = 115;
					itemDef.modifiedModelColors[0] = 5409;
					itemDef.originalModelColors[1] = 107;
					itemDef.modifiedModelColors[1] = 5404;
					itemDef.originalModelColors[2] = 10167;
					itemDef.modifiedModelColors[2] = 6449;
					itemDef.originalModelColors[3] = 10171;
					itemDef.modifiedModelColors[3] = 7390;
					//itemDef.destItemColors = new int[] { 115, 107, 10167, 10171 };
					//itemDef.srcItemColors = new int[] { 5409, 5404, 6449, 7390 };
					itemDef.itemActions = new String[] { null, "Wield", null, null, "Drop" };
					itemDef.modelID = 19967;
					itemDef.anInt165 = 19839;
					itemDef.anInt200 = 19839;
					break;
				
				case 12004:
					itemDef.name = "Kraken tentacle";
					itemDef.modelZoom = 1095;
					itemDef.modelRotationY = 593;
					itemDef.modelRotationX = 741;
					itemDef.modelOffset1 = 4;
					itemDef.modelOffset2 = 4;
					itemDef.modifiedModelColors = new int[4];
					itemDef.originalModelColors = new int[4];
					itemDef.originalModelColors[0] = 8097;
					itemDef.originalModelColors[1] = 9121;
					itemDef.originalModelColors[2] = 8092;
					itemDef.originalModelColors[3] = 9118;
					itemDef.modifiedModelColors[0] = 11148;
					itemDef.modifiedModelColors[1] = 10772;
					itemDef.modifiedModelColors[2] = 10652;
					itemDef.modifiedModelColors[3] = 10533;
					//itemDef.destItemColors = new int[] { 8097, 9121, 8092, 9118 };
					//itemDef.srcItemColors = new int[] { 11148, 10772, 10652, 10533 };
					itemDef.itemActions[4] = "Drop";
					itemDef.modelID = 28437;
					break;
					
				case 12006:
					itemDef.name = "Abyssal tentacle";
					itemDef.modelZoom = 840;
					itemDef.modelRotationY = 280;
					itemDef.modelRotationX = 121;
					itemDef.modelOffset1 = 3;
					itemDef.modelOffset2 = 56;
					itemDef.modelID = 28439;
					itemDef.itemActions[1] = "Wield";
					itemDef.itemActions[3] = "Check";
					itemDef.itemActions[4] = "Dissolve";
					itemDef.anInt165 = 28446;
					itemDef.anInt200 = 28446;
					break;
					
				case 11924:
					itemDef.name = "Malediction ward";
					itemDef.modelZoom = 1200;
					itemDef.modelRotationY = 568;
					itemDef.modelRotationX = 1836;
					itemDef.modelOffset1 = 2;
					itemDef.modelOffset2 = 3;
					itemDef.modifiedModelColors = new int[1];
					itemDef.originalModelColors = new int[1];
					itemDef.modifiedModelColors[0] = 908;
					itemDef.originalModelColors[0] = -21608;
					//itemDef.destItemColors = new int[] { -21608 };
					//itemDef.srcItemColors = new int[] { 908 };
					itemDef.modelID = 9354;
					itemDef.itemActions[1] = "Wield";
					itemDef.itemActions[4] = "Drop";
					itemDef.anInt165 = 9347;
					itemDef.anInt200 = 9347;
					break;
					
				case 11926:
					itemDef.name = "Odium ward";
					itemDef.modelZoom = 1200;
					itemDef.modelRotationY = 568;
					itemDef.modelRotationX = 1836;
					itemDef.modelOffset1 = 2;
					itemDef.modelOffset2 = 3;
					itemDef.modifiedModelColors = new int[1];
					itemDef.originalModelColors = new int[1];
					itemDef.modifiedModelColors[0] = 908;
					itemDef.originalModelColors[0] = 15252;
					//itemDef.destItemColors = new int[] { 15252 };
					//itemDef.srcItemColors = new int[] { 908 };
					itemDef.modelID = 9354;
					itemDef.itemActions[1] = "Wield";
					itemDef.itemActions[4] = "Drop";
					itemDef.anInt165 = 9347;
					itemDef.anInt200 = 9347;
					break;
					
				case 11905:
					itemDef.name = "Trident of the seas (full)";
					itemDef.anInt200 = 1052;
				    itemDef.anInt165 = 1052;
				    itemDef.modelID = 1051;
				    itemDef.modelRotationY = 420;
				    itemDef.modelRotationX = 1130;
				    itemDef.modelZoom = 2755;
				    itemDef.modelOffset2 = 0;
				    itemDef.modelOffset1 = 0;
					itemDef.itemActions[1] = "Wield";
					itemDef.itemActions[2] = "Check";
					itemDef.itemActions[3] = "Uncharge";
					itemDef.itemActions[4] = "Drop";
					break;
					
				case 11907:
					 itemDef.name = "Trident of the seas";
				       itemDef.description = "A weapon from the deep."
				       .getBytes();
				       itemDef.anInt200 = 1052;
				       itemDef.anInt165 = 1052;
				       itemDef.modelID = 1051;
				       itemDef.modelRotationY = 420;
				       itemDef.modelRotationX = 1130;
				       itemDef.modelZoom = 2755;
				       itemDef.modelOffset2 = 0;
				       itemDef.modelOffset1 = 0;
				       itemDef.itemActions = new String[5];
				       itemDef.itemActions[1] = "Wield";
				       itemDef.itemActions[3] = "Check";
					break;
					
				case 11908:
					itemDef.name = "Uncharged trident";
					itemDef.anInt200 = 1052;
				       itemDef.anInt165 = 1052;
				       itemDef.modelID = 1051;
				       itemDef.modelRotationY = 420;
				       itemDef.modelRotationX = 1130;
				       itemDef.modelZoom = 2755;
				       itemDef.modelOffset2 = 0;
				       itemDef.modelOffset1 = 0;
					itemDef.itemActions[1] = "Wield";
					itemDef.itemActions[2] = "Check";
					itemDef.itemActions[4] = "Drop";
					
					break;
		case 12007:
			itemDef.name = "Spirit terrorbird pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30651;
			itemDef.description = "Spirit terrorbird pouch".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12008:
			itemDef.name = "Spirit terrorbird pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit terrorbird pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12009:
			itemDef.name = "Granite crab pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30676;
			itemDef.description = "Granite crab pouch".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12010:
			itemDef.name = "Granite crab pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Granite crab pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12011:
			itemDef.name = "Praying mantis pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30716;
			itemDef.description = "Praying mantis pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12012:
			itemDef.name = "Praying mantis pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Praying mantis pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12013:
			itemDef.name = "Giant ent pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30622;
			itemDef.description = "Giant ent pouch".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12014:
			itemDef.name = "Giant ent pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Giant ent pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12015:
			itemDef.name = "Spirit cobra pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30779;
			itemDef.description = "Spirit cobra pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12016:
			itemDef.name = "Spirit cobra pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit cobra pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12017:
			itemDef.name = "Spirit dagannoth pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30604;
			itemDef.description = "Spirit dagannoth pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12018:
			itemDef.name = "Spirit dagannoth pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit dagannoth pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12019:
			itemDef.name = "Thorny snail pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30670;
			itemDef.description = "Thorny snail pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12020:
			itemDef.name = "Thorny snail pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Thorny snail pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12021:
			itemDef.name = "Beaver pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30812;
			itemDef.description = "Beaver pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12022:
			itemDef.name = "Beaver pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Beaver pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12023:
			itemDef.name = "Karam. overlord pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30842;
			itemDef.description = "Karam. overlord pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12024:
			itemDef.name = "Karam. overlord pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Karam. overlord pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12025:
			itemDef.name = "Hydra pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30625;
			itemDef.description = "Hydra pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12026:
			itemDef.name = "Hydra pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Hydra pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12027:
			itemDef.name = "Spirit jelly pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30847;
			itemDef.description = "Spirit jelly pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12028:
			itemDef.name = "Spirit jelly pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit jelly pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12029:
			itemDef.name = "Bunyip pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30635;
			itemDef.description = "Bunyip pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12030:
			itemDef.name = "Bunyip pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Bunyip pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12031:
			itemDef.name = "War tortoise pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30819;
			itemDef.description = "War tortoise pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12032:
			itemDef.name = "War tortoise pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a War tortoise pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12033:
			itemDef.name = "Fruit bat pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30586;
			itemDef.description = "Fruit bat pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12034:
			itemDef.name = "Fruit bat pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Fruit bat pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12035:
			itemDef.name = "Abyssal parasite pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30699;
			itemDef.description = "Abyssal parasite pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12036:
			itemDef.name = "Abyssal parasite pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Abyssal parasite pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12037:
			itemDef.name = "Abyssal lurker pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30692;
			itemDef.description = "Abyssal lurker pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12038:
			itemDef.name = "Abyssal lurker pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Abyssal lurker pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12039:
			itemDef.name = "Unicorn stallion pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30811;
			itemDef.description = "Unicorn stallion pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12040:
			itemDef.name = "Unicorn stallion pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Unicorn stallion pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12041:
			itemDef.name = "Magpie pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30711;
			itemDef.description = "Magpie pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12042:
			itemDef.name = "Magpie pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Magpie pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12043:
			itemDef.name = "Dreadfowl pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30664;
			itemDef.description = "Dreadfowl pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12044:
			itemDef.name = "Dreadfowl pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Dreadfowl pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12045:
			itemDef.name = "Stranger plant pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30718;
			itemDef.description = "Stranger plant pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12046:
			itemDef.name = "Stranger plant pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Stranger plant pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12047:
			itemDef.name = "Spirit wolf pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30591;
			itemDef.description = "Spirit wolf pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12048:
			itemDef.name = "Spirit wolf pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit wolf pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12049:
			itemDef.name = "Desert wyrm pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30735;
			itemDef.description = "Desert wyrm pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12050:
			itemDef.name = "Desert wyrm pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Desert wyrm pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12051:
			itemDef.name = "Evil turnip pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30739;
			itemDef.description = "Evil turnip pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12052:
			itemDef.name = "Evil turnip pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Evil turnip pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12053:
			itemDef.name = "Vampire bat pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30640;
			itemDef.description = "Vampire bat pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12054:
			itemDef.name = "Vampire bat pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Vampire bat pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12055:
			itemDef.name = "Spirit scorpion pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30807;
			itemDef.description = "Spirit scorpion pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12056:
			itemDef.name = "Spirit scorpion pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit scorpion pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12057:
			itemDef.name = "Arctic bear pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30777;
			itemDef.description = "Arctic bear pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12058:
			itemDef.name = "Arctic bear pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Arctic bear pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12059:
			itemDef.name = "Spirit spider pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30764;
			itemDef.description = "Spirit spider pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12060:
			itemDef.name = "Spirit spider pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit spider pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12061:
			itemDef.name = "Bloated leech pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30644;
			itemDef.description = "Bloated leech pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12062:
			itemDef.name = "Bloated leech pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Bloated leech pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12063:
			itemDef.name = "Spirit kalphite pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30800;
			itemDef.description = "Spirit kalphite pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12064:
			itemDef.name = "Spirit kalphite pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit kalphite pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12065:
			itemDef.name = "Honey badger pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30597;
			itemDef.description = "Honey badger pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12066:
			itemDef.name = "Honey badger pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Honey badger pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12067:
			itemDef.name = "Albino rat pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30588;
			itemDef.description = "Albino rat pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12068:
			itemDef.name = "Albino rat pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Albino rat pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12069:
			itemDef.name = "Granite lobster pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30794;
			itemDef.description = "Granite lobster pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12070:
			itemDef.name = "Granite lobster pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Granite lobster pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12071:
			itemDef.name = "Macaw pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30610;
			itemDef.description = "Macaw pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12072:
			itemDef.name = "Macaw pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Macaw pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12073:
			itemDef.name = "Bronze minotaur pouch";
			itemDef.itemActions = new String[5]; 
			itemDef.itemActions[3] = "Summon";
			itemDef.itemActions[4] = "Drop";
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Bronze minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			/*itemDef.modifiedModelColors[0] = 5656;
			itemDef.modifiedModelColors[1] = 5652;
			itemDef.modifiedModelColors[2] = 5904;
			itemDef.modifiedModelColors[3] = 6674;
			itemDef.modifiedModelColors[4] = 6798;
			itemDef.modifiedModelColors[5] = 7050;
			itemDef.originalModelColors[0] = 7362;
			itemDef.originalModelColors[1] = 7357;
			itemDef.originalModelColors[2] = 8367;
			itemDef.originalModelColors[3] = 7339;
			itemDef.originalModelColors[4] = 7335;
			itemDef.originalModelColors[5] = 7331;*/
			break;
		case 12074:
			itemDef.name = "Bronze minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Bronze minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12075:
			itemDef.name = "Iron minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Iron minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			//itemDef.modifiedModelColors[0] = 37;
			//itemDef.modifiedModelColors[1] = 33;
			//itemDef.modifiedModelColors[2] = 28;
			//itemDef.modifiedModelColors[3] = 20;
			//itemDef.modifiedModelColors[4] = 16;
			//itemDef.modifiedModelColors[5] = 12;
			//itemDef.originalModelColors[0] = 7362;
			//itemDef.originalModelColors[1] = 7357;
			//itemDef.originalModelColors[2] = 8367;
			//itemDef.originalModelColors[3] = 7339;
			//itemDef.originalModelColors[4] = 7335;
			//itemDef.originalModelColors[5] = 7331;
			break;
		case 12076:
			itemDef.name = "Iron minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Iron minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12077:
			itemDef.name = "Steel minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Steel minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			/*itemDef.modifiedModelColors[0] = 70;
			itemDef.modifiedModelColors[1] = 66;
			itemDef.modifiedModelColors[2] = 61;
			itemDef.modifiedModelColors[3] = 41;
			itemDef.modifiedModelColors[4] = 37;
			itemDef.modifiedModelColors[5] = 33;
			itemDef.originalModelColors[0] = 7362;
			itemDef.originalModelColors[1] = 7357;
			itemDef.originalModelColors[2] = 8367;
			itemDef.originalModelColors[3] = 7339;
			itemDef.originalModelColors[4] = 7335;
			itemDef.originalModelColors[5] = 7331;*/
			break;
		case 12078:
			itemDef.name = "Steel minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Steel minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12079:
			itemDef.name = "Mithril minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Mithril minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			/*itemDef.modifiedModelColors[0] = 43173;
			itemDef.modifiedModelColors[1] = 43297;
			itemDef.modifiedModelColors[2] = 43292;
			itemDef.modifiedModelColors[3] = 43292;
			itemDef.modifiedModelColors[4] = 43288;
			itemDef.modifiedModelColors[5] = 43412;
			itemDef.originalModelColors[0] = 7362;
			itemDef.originalModelColors[1] = 7357;
			itemDef.originalModelColors[2] = 8367;
			itemDef.originalModelColors[3] = 7339;
			itemDef.originalModelColors[4] = 7335;
			itemDef.originalModelColors[5] = 7331;*/
			break;
		case 12080:
			itemDef.name = "Mithril minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Mithril minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12081:
			itemDef.name = "Adamant minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Adamant minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			/*itemDef.modifiedModelColors[0] = 21667;
			itemDef.modifiedModelColors[1] = 21662;
			itemDef.modifiedModelColors[2] = 21658;
			itemDef.modifiedModelColors[3] = 21656;
			itemDef.modifiedModelColors[4] = 21652;
			itemDef.modifiedModelColors[5] = 21776;
			itemDef.originalModelColors[0] = 7362;
			itemDef.originalModelColors[1] = 7357;
			itemDef.originalModelColors[2] = 8367;
			itemDef.originalModelColors[3] = 7339;
			itemDef.originalModelColors[4] = 7335;
			itemDef.originalModelColors[5] = 7331;*/
			break;
		case 12082:
			itemDef.name = "Adamant minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Adamant minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12083:
			itemDef.name = "Rune minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30780;
			itemDef.description = "Rune minotaur pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			/*itemDef.modifiedModelColors[0] = 36137;
			itemDef.modifiedModelColors[1] = 36133;
			itemDef.modifiedModelColors[2] = 36257;
			itemDef.modifiedModelColors[3] = 36372;
			itemDef.modifiedModelColors[4] = 36624;
			itemDef.modifiedModelColors[5] = 36748;
			itemDef.originalModelColors[0] = 7362;
			itemDef.originalModelColors[1] = 7357;
			itemDef.originalModelColors[2] = 8367;
			itemDef.originalModelColors[3] = 7339;
			itemDef.originalModelColors[4] = 7335;
			itemDef.originalModelColors[5] = 7331;*/
			break;
		case 12084:
			itemDef.name = "Rune minotaur pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Rune minotaur pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12085:
			itemDef.name = "Smoke devil pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30582;
			itemDef.description = "Smoke devil pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12086:
			itemDef.name = "Smoke devil pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Smoke devil pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12087:
			itemDef.name = "Bull ant pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30827;
			itemDef.description = "Bull ant pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12088:
			itemDef.name = "Bull ant pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Bull ant pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12089:
			itemDef.name = "Wolpertinger pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30758;
			itemDef.description = "Wolpertinger pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12090:
			itemDef.name = "Wolpertinger pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Wolpertinger pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12091:
			itemDef.name = "Compost mound pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30648;
			itemDef.description = "Compost mound pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12092:
			itemDef.name = "Compost mound pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Compost mound pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12093:
			itemDef.name = "Pack yak pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30837;
			itemDef.description = "Pack yak pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12094:
			itemDef.name = "Pack yak pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Pack yak pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12095:
			itemDef.name = "Sp. cockatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. cockatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12096:
			itemDef.name = "Sp. cockatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. cockatrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12097:
			itemDef.name = "Sp. guthatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. guthatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 10458;
			itemDef.modifiedModelColors[1] = 19361;
			itemDef.modifiedModelColors[2] = 18341;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12098:
			itemDef.name = "Sp. guthatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. guthatrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12099:
			itemDef.name = "Sp. saratrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. saratrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 10326;
			itemDef.modifiedModelColors[1] = 33088;
			itemDef.modifiedModelColors[2] = 33096;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12100:
			itemDef.name = "Sp. saratrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. saratrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12101:
			itemDef.name = "Sp. zamatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. zamatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 3239;
			itemDef.modifiedModelColors[1] = 1438;
			itemDef.modifiedModelColors[2] = 2737;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12102:
			itemDef.name = "Sp. zamatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. zamatrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12103:
			itemDef.name = "Sp. pengatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30623;
			itemDef.description = "Sp. pengatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 3239;
			itemDef.modifiedModelColors[1] = 3239;
			itemDef.modifiedModelColors[2] = 3235;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12104:
			itemDef.name = "Sp. pengatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. pengatrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12105:
			itemDef.name = "Sp. coraxatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. coraxatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 28;
			itemDef.modifiedModelColors[1] = 28;
			itemDef.modifiedModelColors[2] = 24;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12106:
			itemDef.name = "Sp. coraxatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Sp. coraxatrice pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12107:
			itemDef.name = "Sp. vulatrice pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30787;
			itemDef.description = "Sp. vulatrice pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;
			itemDef.modifiedModelColors[0] = 3239;
			itemDef.modifiedModelColors[1] = 3239;
			itemDef.modifiedModelColors[2] = 3235;
			itemDef.originalModelColors[0] = 8497;
			itemDef.originalModelColors[1] = 1455;
			itemDef.originalModelColors[2] = 1447;
			break;
		case 12420:
			itemDef.name = "Pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		/*case 12524:
			itemDef.name = "Summoning cape";
			itemDef.itemActions = new String[] {null, "Wear", null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = 31629;
			itemDef.anInt200 = 31562;
			itemDef.modelID = 31094;
			itemDef.description = "Summoning cape".getBytes();
			itemDef.modelZoom = 2128;
			itemDef.modelRotationY = 504;
			itemDef.modelRotationX = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 1;
			itemDef.modifiedModelColors[0] = 38119;
			itemDef.modifiedModelColors[1] = 127;
			itemDef.originalModelColors[0] = 57280;
			itemDef.originalModelColors[1] = 54183;
			break;*/
		case 12526:
			itemDef.name = "Spirit wolf pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Destroy", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30591;
			itemDef.description = "Spirit wolf pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12776:
			itemDef.name = "Swamp titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30589;
			itemDef.description = "Swamp titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12777:
			itemDef.name = "Swamp titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Swamp titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12778:
			itemDef.name = "Spirit mosquito pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30840;
			itemDef.description = "Spirit mosquito pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12779:
			itemDef.name = "Spirit mosquito pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit mosquito pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12780:
			itemDef.name = "Void spinner pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30786;
			itemDef.description = "Void spinner pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12781:
			itemDef.name = "Void spinner pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Void spinner pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12782:
			itemDef.name = "Forge regent pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30810;
			itemDef.description = "Forge regent pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12783:
			itemDef.name = "Forge regent pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Forge regent pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12784:
			itemDef.name = "Spirit larupia pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30693;
			itemDef.description = "Spirit larupia pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12785:
			itemDef.name = "Spirit larupia pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit larupia pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12786:
			itemDef.name = "Geyser titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30769;
			itemDef.description = "Geyser titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12787:
			itemDef.name = "Geyser titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Geyser titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12788:
			itemDef.name = "Lava titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30697;
			itemDef.description = "Lava titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12789:
			itemDef.name = "Lava titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Lava titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12790:
			itemDef.name = "Steel titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30737;
			itemDef.description = "Steel titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12791:
			itemDef.name = "Steel titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Steel titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12792:
			itemDef.name = "Obsidian golem pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30681;
			itemDef.description = "Obsidian golem pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12793:
			itemDef.name = "Obsidian golem pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Obsidian golem pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12794:
			itemDef.name = "Talon beast pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30602;
			itemDef.description = "Talon beast pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12795:
			itemDef.name = "Talon beast pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Talon beast pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		
		/*case 12796:
			itemDef.name = "Abyssal titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30830;
			itemDef.description = "Abyssal titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;*/
		case 12797:
			itemDef.name = "Abyssal titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Abyssal titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12798:
			itemDef.name = "Void torcher pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30671;
			itemDef.description = "Void torcher pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12799:
			itemDef.name = "Void torcher pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Void torcher pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12800:
			itemDef.name = "Giant chinchompa pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30598;
			itemDef.description = "Giant chinchompa pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12801:
			itemDef.name = "Giant chinchompa pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Giant chinchompa pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12802:
			itemDef.name = "Fire titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30743;
			itemDef.description = "Fire titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12803:
			itemDef.name = "Fire titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Fire titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12804:
			itemDef.name = "Moss titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30846;
			itemDef.description = "Moss titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12805:
			itemDef.name = "Moss titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Moss titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12806:
			itemDef.name = "Ice titan pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30836;
			itemDef.description = "Ice titan pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12807:
			itemDef.name = "Ice titan pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for an Ice titan pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12808:
			itemDef.name = "Spirit tz-kih pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30844;
			itemDef.description = "Spirit tz-kih pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12809:
			itemDef.name = "Spirit tz-kih pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit tz-kih pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12810:
			itemDef.name = "Spirit graahk pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30642;
			itemDef.description = "Spirit graahk pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12811:
			itemDef.name = "Spirit graahk pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit graahk pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12812:
			itemDef.name = "Spirit kyatt pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30717;
			itemDef.description = "Spirit kyatt pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12813:
			itemDef.name = "Spirit kyatt pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Spirit kyatt pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12814:
			itemDef.name = "Void shifter pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30799;
			itemDef.description = "Void shifter pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12815:
			itemDef.name = "Void shifter pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Void shifter pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12816:
			itemDef.name = "Pyrelord pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30776;
			itemDef.description = "Pyrelord pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12817:
			itemDef.name = "Pyrelord pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Pyrelord pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12818:
			itemDef.name = "Void ravager pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30703;
			itemDef.description = "Void ravager pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12819:
			itemDef.name = "Void ravager pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Void ravager pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12820:
			itemDef.name = "Ravenous locust pouch";
			itemDef.itemActions = new String[] {null, null, null, "Summon", "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30695;
			itemDef.description = "Ravenous locust pouch.".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 12821:
			itemDef.name = "Ravenous locust pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 2429;
			itemDef.description = "Swap this note at any bank for a Ravenous locust pouch.".getBytes();
			itemDef.modelZoom = 760;
			itemDef.modelRotationY = 552;
			itemDef.modelRotationX = 28;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 2;

			break;
		case 12162:
			itemDef.name = "Spirit shards";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 31279;
			itemDef.description = "Spirit shards".getBytes();
			itemDef.modelZoom = 1308;
			itemDef.modelRotationY = 553;
			itemDef.modelRotationX = 1950;
			itemDef.modelOffset1 = 3;
			itemDef.modelOffset2 = 1;

			break;
		case 12158:
			itemDef.name = "Gold charm";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 31553;
			itemDef.description = "Gold charm".getBytes();
			itemDef.modelZoom = 550;
			itemDef.modelRotationY = 310;
			itemDef.modelRotationX = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;

			break;
		case 12159:
			itemDef.name = "Green charm";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 31543;
			itemDef.description = "Green charm".getBytes();
			itemDef.modelZoom = 550;
			itemDef.modelRotationY = 310;
			itemDef.modelRotationX = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;

			break;
		case 12160:
			itemDef.name = "Crimson charm";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 31525;
			itemDef.description = "Crimson charm".getBytes();
			itemDef.modelZoom = 550;
			itemDef.modelRotationY = 310;
			itemDef.modelRotationX = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;

			break;
		case 15262:
			itemDef.name = "Spirit shard pack";
			itemDef.itemActions = new String[] {"Open", null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 48608;
			itemDef.description = "Spirit shard pack".getBytes();
			itemDef.modelZoom = 2000;
			itemDef.modelRotationY = 102;
			itemDef.modelRotationX = 270;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 5;

			break;
		case 12163:
			itemDef.name = "Blue charm";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 31531;
			itemDef.description = "Blue charm".getBytes();
			itemDef.modelZoom = 550;
			itemDef.modelRotationY = 310;
			itemDef.modelRotationX = 0;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 0;

			break;
		case 12225:
			itemDef.name = "Pouch";
			itemDef.itemActions = new String[] {null, null, null, null, "Drop", };
			itemDef.groundActions = new String[] {null, null, "Take", null, null, };
			itemDef.anInt165 = -1;
			itemDef.anInt200 = -1;
			itemDef.modelID = 30624;
			itemDef.description = "Pouch".getBytes();
			itemDef.modelZoom = 1049;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 1033;
			itemDef.modelOffset1 = 1;
			itemDef.modelOffset2 = 3;

			break;
		case 15600:
			itemDef.name = "Valiant hat";
			break;
			
		case 15098:
			itemDef.name = "Dice (up to 100)";
			itemDef.modelZoom = 1104;
			itemDef.modelRotationX = 215;
			itemDef.modelRotationY = 94;
			itemDef.modelOffset2 = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			//itemDef.itemActions[1] = "Public-roll";
			itemDef.itemActions[3] = "Roll Dice";
			itemDef.itemActions[4] = "Drop";
			itemDef.modelID = 47852;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;
		case 15088:
			itemDef.name = "Dice (2, 6 sides)";
			itemDef.modelZoom = 1104;
			itemDef.modelRotationX = 215;
			itemDef.modelRotationY = 94;
			itemDef.modelOffset2 = 1;
			itemDef.groundActions = new String[] { null, null, "Take", null,
					null };
			itemDef.itemActions[1] = "Public-roll";
			itemDef.itemActions[2] = "Switch-dice";
			itemDef.itemActions[4] = "Drop";
			itemDef.modelID = 47841;
			itemDef.anInt196 = 15;
			itemDef.anInt184 = 25;
			break;
		case 13263:
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wield";
			itemDef.modelZoom = 789;
			itemDef.modelRotationY = 69;
			itemDef.modelRotationX = 1743;
			itemDef.modelOffset1 = -4;
			itemDef.modelOffset2 = -3;
			itemDef.modelID = 34411;
			itemDef.anInt165 = 6775; // male wield model
			itemDef.anInt200 = 14112; // femArmModel
			itemDef.name = "Slayer helmet";
			itemDef.description = "You don't want to wear it inside-out."
					.getBytes();// examine.
			break;
		case 405:
			itemDef.name = "2.5m Cash";
			itemDef.description = "Opening this casket will give you 2,500,000 coins."
					.getBytes();
			break;

		case 761:
			itemDef.name = "2x Global";
			itemDef.description = "Reading this will reward you will 2x experience for all skills. (30 Minutes)"
					.getBytes();
			break;

		case 607:
			itemDef.name = "2x Combat";
			itemDef.description = "Reading this will reward you will 2x experience for combat skills only. (30 Minutes)"
					.getBytes();
			break;

		case 608:
			itemDef.name = "2x Skilling";
			itemDef.description = "Reading this will reward you will 2x experience for non-combat skills only. (30 Minutes)"
					.getBytes();
			break;
		case 6950:
			itemDef.itemActions[1] = "Cast";
			itemDef.name = "@gre@Vengeance";
			itemDef.description = "Rebound damage to an opponent.".getBytes();
			break;
		case 15330:
			itemDef.name = "Halloween ring";
			itemDef.modelID = 2677;
			itemDef.modelZoom = 830;
			itemDef.modelRotationY = 322;
			itemDef.modelRotationX = 135;
			itemDef.itemActions[1] = "Wear";
			break;

		case 15332:
			itemDef.name = "Ring of slaying";
			itemDef.modelID = 2677;
			itemDef.modelZoom = 830;
			itemDef.modelRotationY = 322;
			itemDef.modelRotationX = 135;
			itemDef.modelOffset1 = -1;
			itemDef.modelOffset1 = 1;
			itemDef.itemActions[1] = "Wear";
			itemDef.originalModelColors = new int[1];
			itemDef.modifiedModelColors = new int[1];
			itemDef.originalModelColors[0] = 51111;
			itemDef.modifiedModelColors[0] = 127;
			break;
			
		case 13858:
		itemDef.name = "Zuriel's robe top";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";  
		itemDef.anInt165 = 42627;
		itemDef.anInt200 = 42642;
		itemDef.modelID = 42591;
		itemDef.description = "Zuriel's robe top".getBytes();
		itemDef.modelZoom = 1373;
		itemDef.modelRotationY = 373;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = -7;
		break;
		case 13861:
		itemDef.name = "Zuriel's robe bottom";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.anInt165 = 42634;
		itemDef.anInt200 = 42645;
		itemDef.modelID = 42588;
		itemDef.description = "Zuriel's robe bottom".getBytes();
		itemDef.modelZoom = 1697;
		itemDef.modelRotationY = 512;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = 2;
		itemDef.modelOffset2 = -9;
		break;
		case 13864:
		itemDef.name = "Zuriel's hood";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.anInt165 = 42638;
		itemDef.anInt200 = 42653;
		itemDef.modelID = 42604;
		itemDef.description = "Zuriel's hood".getBytes();
		itemDef.modelZoom = 720;
		itemDef.modelRotationY = 28;
		itemDef.modelRotationX = 0;
		itemDef.modelOffset1 = 1;
		itemDef.modelOffset2 = 1;
		
		break;
		case 13867:
		itemDef.name = "Zuriel's staff";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.anInt165 = 42617;
		itemDef.anInt200 = 42617;
		itemDef.modelID = 42595;
		itemDef.description = "Zuriel's staff".getBytes();
		itemDef.modelZoom = 2000;
		itemDef.modelRotationY = 366;
		itemDef.modelRotationX = 3;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		break;
		
case 13870:
itemDef.name = "Morrigan's leather body";
itemDef.itemActions = new String[5]; 
itemDef.itemActions[1] = "Wear";
itemDef.anInt165 = 42626;
itemDef.anInt200 = 42643;
itemDef.modelID = 42578;
itemDef.description = "Morrigan's leather body".getBytes();
itemDef.modelZoom = 1440;
itemDef.modelRotationY = 545;
itemDef.modelRotationX = 2;
itemDef.modelOffset1 = -2;
itemDef.modelOffset2 = 5;
break;

case 13873:
itemDef.name = "Morrigan's leather chaps";
itemDef.itemActions = new String[5]; 
itemDef.itemActions[1]= "Take"; 
itemDef.anInt165 = 42631;
itemDef.anInt200 = 42646;
itemDef.modelID = 42603;
itemDef.description = "Morrigan's leather chaps".getBytes();
itemDef.modelZoom = 1753;
itemDef.modelRotationY = 482;
itemDef.modelRotationX = 1;
itemDef.modelOffset1 = -3;
itemDef.modelOffset2 = 11;
break;

case 13876:
itemDef.name = "Morrigan's coif";
itemDef.itemActions = new String[5]; 
itemDef.itemActions[1] = "Take";
itemDef.anInt165 = 42636;
itemDef.anInt200 = 42652;
itemDef.modelID = 42583;
itemDef.description = "Morrigan's coif".getBytes();
itemDef.modelZoom = 592;
itemDef.modelRotationY = 537;
itemDef.modelRotationX = 5;
itemDef.modelOffset1 = -3;
itemDef.modelOffset2 = 6;
break;
			
			
			 
		case 15004:
			itemDef.name = "Vesta's chainbody";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.anInt165 = 42624;
			itemDef.anInt200 = 42644;
			itemDef.modelID = 42593;
			itemDef.description = null;
			itemDef.modelZoom = 1440;
			itemDef.modelRotationY = 545;
			itemDef.modelRotationX = 2;
			itemDef.modelOffset1 = 4;
			itemDef.modelOffset2 = 5;
		break;
		
		case 15005:
			itemDef.name = "Vesta's plateskirt";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.anInt165 = 42633;
			itemDef.anInt200 = 42649;
			itemDef.modelID = 42581;
			itemDef.modelZoom = 1753;
			itemDef.modelRotationY = 562;
			itemDef.modelRotationX = 1;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = 11;
			itemDef.description = "An ancient plateskirt once worn by Vesta.".getBytes();
		break;
		case 15006:
		itemDef.name = "Vesta's longsword";
		itemDef.itemActions = new String[5];
		itemDef.itemActions[1] = "Wear";
		itemDef.anInt165 = 42615;
		itemDef.anInt200 = 42615;
		itemDef.modelID = 42597;
		itemDef.description = "Vesta's longsword".getBytes();
		itemDef.modelZoom = 1744;
		itemDef.modelRotationY = 738;
		itemDef.modelRotationX = 1985;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		break;
		case 15007:
			itemDef.name = "Vesta's Spear";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.modelID = 42599;
			itemDef.modelZoom = 2022;
			itemDef.modelRotationY = 480;
			itemDef.modelRotationX = 15;
			itemDef.anInt204 = 0;
			itemDef.aByte205 = 14;
			itemDef.aByte154 = 0;
			itemDef.modelOffset2 = 5;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42614;
			itemDef.anInt200 = 42614;
			itemDef.description = "An ancient spear once worn by Vesta.".getBytes();
		break;
		case 15017:
			itemDef.name = "Statius's Platebody";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.modelID = 42602;
			itemDef.modelZoom = 1312;
			itemDef.modelRotationY = 272;
			itemDef.modelRotationX = 2047;
			itemDef.modelOffset2 = 39;
			itemDef.modelOffset1 = -2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42625;
			itemDef.anInt200 = 42641;
		itemDef.description = "An ancient platebody once worn by Statius.".getBytes();
		break;
		case 15018:
			itemDef.name = "Statius's Platelegs";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.modelID = 42590;
			itemDef.modelZoom = 1625;
			itemDef.modelRotationY = 355;
			itemDef.modelRotationX = 2046;
			itemDef.modelOffset2 = -11;
			itemDef.modelOffset1 = 0;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42632;
			itemDef.anInt200 = 42647;
		itemDef.description = "An ancient platelegs once worn by Statius.".getBytes();
		break;
		case 15019:
			itemDef.name = "Statius's Full Helm";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear";
			itemDef.modelID = 42596;
			itemDef.modelZoom = 789;
			itemDef.modelRotationY = 96;
			itemDef.modelRotationX = 2039;
			itemDef.modelOffset2 = -7;
			itemDef.modelOffset1 = 2;
			itemDef.anInt204 = 0;
			itemDef.anInt165 = 42639;
			itemDef.anInt200 = 42655;
		itemDef.description = "An ancient full helm once worn by Statius.".getBytes();
		break;
		case 15020:
			itemDef.name = "Statius's Warhammer";
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wear"; 
			itemDef.anInt165 = 42623;
			itemDef.anInt200 = 42623;
			itemDef.modelID = 42577;
			itemDef.modelZoom = 1360;
			itemDef.modelRotationY = 507;
			itemDef.modelRotationX = 27;
			itemDef.modelOffset1 = 7;
			itemDef.modelOffset2 = 6;
		itemDef.description = "An ancient warhammer once used by Statius.".getBytes();
		break;
		
		case 14484:
			 itemDef.itemActions = new String[5];
                itemDef.itemActions[1] = "Wield";
                itemDef.modelID = 44590;
                itemDef.anInt165 = 43660;//anInt165
                itemDef.anInt200 = 43660;//anInt200
                itemDef.modelZoom = 789;
                itemDef.modelRotationY = 240;
                itemDef.modelRotationX = 60;
                itemDef.modelOffset1 = -1;
                itemDef.modelOffset2 = -23;
                itemDef.name = "Dragon claws";
                itemDef.description = "A set of fighting claws.".getBytes();
		break;
		
		
		case 13734:
		itemDef.name = "Spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40943;
		 itemDef.anInt200 = 40943;
		itemDef.modelID = 40919;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13736:
		itemDef.name = "Blessed spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
        itemDef.anInt165 = 40941;
		 itemDef.anInt200 = 40941;
		itemDef.modelID = 40913;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13738:
		itemDef.name = "Arcane spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40944;
		 itemDef.anInt200 = 40944;
		itemDef.modelID = 40922;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13740:
		itemDef.name = "Divine spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40939;
		 itemDef.anInt200 = 40939;
		itemDef.modelID = 40921;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13742:
		itemDef.name = "Elysian spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40942;
		 itemDef.anInt200 = 40942;
		itemDef.modelID = 40915;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13744:
		itemDef.name = "Spectral spirit shield";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40940;
		 itemDef.anInt200 = 40940;
		itemDef.modelID = 40920;
		itemDef.description = null;
		itemDef.modelZoom = 1616;
		itemDef.modelRotationY = 396;
		itemDef.modelRotationX = 1050;
		itemDef.modelOffset1 = -3;
		itemDef.modelOffset2 = 4;
		break;
		
		case 13746:
		itemDef.name = "Arcane sigil";
		itemDef.itemActions = new String[5];
		itemDef.anInt165 = -1;
		 itemDef.anInt200 = -1;
		itemDef.modelID = 40914;
		itemDef.description = null;
		itemDef.modelZoom = 789;
		itemDef.modelRotationY = 225;
		itemDef.modelRotationX = 186;
		itemDef.modelOffset1 = 4;
		itemDef.modelOffset2 = -10;
		break;
		
		case 13748:
		itemDef.name = "Divine sigil";
		itemDef.itemActions = new String[5];
		itemDef.anInt165 = -1;
		 itemDef.anInt200 = -1;
		itemDef.modelID = 40916;
		itemDef.description = null;
		itemDef.modelZoom = 848;
		itemDef.modelRotationY = 267;
		itemDef.modelRotationX = 138;
		itemDef.modelOffset1 = 5;
		itemDef.modelOffset2 = 0;
		break;
		
		case 13750:
		itemDef.name = "Elysian sigil";
		itemDef.anInt165 = -1;
		 itemDef.anInt200 = -1;
		itemDef.modelID = 40917;
		itemDef.description = null;
		itemDef.modelZoom = 976;
		itemDef.modelRotationY = 288;
		itemDef.modelRotationX = 225;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		break;
		
		case 13752:
		itemDef.name = "Spectral sigil";
		itemDef.anInt165 = -1;
		 itemDef.anInt200 = -1;
		itemDef.modelID = 40918;
		itemDef.description = null;
		itemDef.modelZoom = 976;
		itemDef.modelRotationY = 267;
		itemDef.modelRotationX = 1304;
		itemDef.modelOffset1 = -5;
		itemDef.modelOffset2 = 0;
		break;
		
		case 13754:
		itemDef.name = "Holy elixir";
		itemDef.anInt165 = -1;
		itemDef.anInt200 = -1;
		itemDef.modelID = 40949;
		itemDef.description = null;
		itemDef.modelZoom = 1178;
		itemDef.modelRotationY = 0;
		itemDef.modelRotationX = 1881;
		itemDef.modelOffset1 = 0;
		itemDef.modelOffset2 = 0;
		break;
		
		/*case 15050:

			itemDef.name = "Completionist Cape";
			itemDef.itemActions = new String[] {"Wear", null, null, null}; 
			itemDef.groundActions = new String[] {null, "Take", null, null}; 
			itemDef.anInt165 = 65297; 
			itemDef.anInt200 = 65297;
			itemDef.modelID = 65270;
			itemDef.description = "Completionist Cape".getBytes();
			itemDef.modelZoom = 1385;
			itemDef.modelRotationY = 279;
			itemDef.modelRotationX = 948;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 24;
			break;

			case 15049:
			itemDef.name = "Max Cape";
			itemDef.itemActions = new String[] {"Wear", null, null, null}; 
			itemDef.groundActions = new String[] {null, "Take", null, null}; 
			itemDef.anInt165 = 65300;
			itemDef.anInt200 = 65322;
			itemDef.modelID = 65262;
			itemDef.description = "Max Cape".getBytes();
			itemDef.modelZoom = 1385;
			itemDef.modelRotationY = 279;
			itemDef.modelRotationX = 948;
			itemDef.modelOffset1 = 0;
			itemDef.modelOffset2 = 24;
			break;*/

		case 15103:
			itemDef.itemActions = new String[5];
			itemDef.itemActions[1] = "Wield";
			itemDef.name = "Hammer"; // Name
			itemDef.description = "A wieldable hammer.".getBytes();
			itemDef.modelRotationY = 356;
			itemDef.modelRotationX = 2012;
			itemDef.modelOffset1 = -3;
			itemDef.modelOffset2 = -1;
			itemDef.modelID = 2376;
			itemDef.anInt165 = 491;
			itemDef.anInt200 = 491;// 21886,253,167,491
			itemDef.modelZoom = 900;
			break;
		
		/*case 13756:
		itemDef.name = "Armadyl Crossbow";
		itemDef.itemActions = new String[5];
        itemDef.itemActions[1] = "Wield";
		itemDef.anInt165 = 40098;
		itemDef.anInt200 = 40098;
		itemDef.modelID = 40099;
		itemDef.description = null;
		itemDef.modelZoom = 1330;
		itemDef.modelRotationY = -36;
		itemDef.modelRotationX = -6;
		itemDef.modelOffset1 = 236;
		itemDef.modelOffset2 = 236;
		break;*/
			
		
		case 2568:
			itemDef.itemActions[2] = "Check charges";
			break;
		}

		if (itemDef.certTemplateID != -1)
			itemDef.toNote();
		return itemDef;
	}

	private void toNote() {
		ItemDef itemDef = forID(certTemplateID);
		modelID = itemDef.modelID;
		modelZoom = itemDef.modelZoom;
		modelRotationY = itemDef.modelRotationY;
		modelRotationX = itemDef.modelRotationX;

		anInt204 = itemDef.anInt204;
		modelOffset1 = itemDef.modelOffset1;
		modelOffset2 = itemDef.modelOffset2;
		modifiedModelColors = itemDef.modifiedModelColors;
		originalModelColors = itemDef.originalModelColors;
		ItemDef itemDef_1 = forID(certID);
		name = itemDef_1.name;
		membersObject = itemDef_1.membersObject;
		value = itemDef_1.value;
		String s = "a";
		char c = itemDef_1.name.charAt(0);
		if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U')
			s = "an";
		description = ("Swap this note at any bank for " + s + " "
				+ itemDef_1.name + ".").getBytes();
		stackable = true;
	}

	public static Sprite getSprite(int i, int j, int k) {
		if (k == 0) {
			Sprite sprite = (Sprite) mruNodes1.insertFromCache(i);
			if (sprite != null && sprite.maxHeight != j
					&& sprite.maxHeight != -1) {
				sprite.unlink();
				sprite = null;
			}
			if (sprite != null)
				return sprite;
		}
		ItemDef itemDef = forID(i);
		if (itemDef.stackIDs == null)
			j = -1;
		if (j > 1) {
			int i1 = -1;
			for (int j1 = 0; j1 < 10; j1++)
				if (j >= itemDef.stackAmounts[j1]
						&& itemDef.stackAmounts[j1] != 0)
					i1 = itemDef.stackIDs[j1];

			if (i1 != -1)
				itemDef = forID(i1);
		}
		Model model = itemDef.method201(1);
		if (model == null)
			return null;
		Sprite sprite = null;
		if (itemDef.certTemplateID != -1) {
			sprite = getSprite(itemDef.certID, 10, -1);
			if (sprite == null)
				return null;
		}
		Sprite enabledSprite = new Sprite(32, 32);
		int k1 = Texture.textureInt1;
		int l1 = Texture.textureInt2;
		int ai[] = Texture.anIntArray1472;
		int ai1[] = DrawingArea.pixels;
		int i2 = DrawingArea.width;
		int j2 = DrawingArea.height;
		int k2 = DrawingArea.topX;
		int l2 = DrawingArea.bottomX;
		int i3 = DrawingArea.topY;
		int j3 = DrawingArea.bottomY;
		Texture.aBoolean1464 = false;
		DrawingArea.initDrawingArea(32, 32, enabledSprite.myPixels);
		DrawingArea.method336(32, 0, 0, 0, 32);
		Texture.method364();
		int k3 = itemDef.modelZoom;
		if (k == -1)
			k3 = (int) (k3 * 1.5D);
		if (k > 0)
			k3 = (int) (k3 * 1.04D);
		int l3 = Texture.anIntArray1470[itemDef.modelRotationY] * k3 >> 16;
		int i4 = Texture.anIntArray1471[itemDef.modelRotationY] * k3 >> 16;
		model.method482(itemDef.modelRotationX, itemDef.anInt204,
				itemDef.modelRotationY, itemDef.modelOffset1, l3
						+ model.modelHeight / 2 + itemDef.modelOffset2, i4
						+ itemDef.modelOffset2);
		for (int i5 = 31; i5 >= 0; i5--) {
			for (int j4 = 31; j4 >= 0; j4--)
				if (enabledSprite.myPixels[i5 + j4 * 32] == 0)
					if (i5 > 0
							&& enabledSprite.myPixels[(i5 - 1) + j4 * 32] > 1)
						enabledSprite.myPixels[i5 + j4 * 32] = 1;
					else if (j4 > 0
							&& enabledSprite.myPixels[i5 + (j4 - 1) * 32] > 1)
						enabledSprite.myPixels[i5 + j4 * 32] = 1;
					else if (i5 < 31
							&& enabledSprite.myPixels[i5 + 1 + j4 * 32] > 1)
						enabledSprite.myPixels[i5 + j4 * 32] = 1;
					else if (j4 < 31
							&& enabledSprite.myPixels[i5 + (j4 + 1) * 32] > 1)
						enabledSprite.myPixels[i5 + j4 * 32] = 1;

		}

		if (k > 0) {
			for (int j5 = 31; j5 >= 0; j5--) {
				for (int k4 = 31; k4 >= 0; k4--)
					if (enabledSprite.myPixels[j5 + k4 * 32] == 0)
						if (j5 > 0
								&& enabledSprite.myPixels[(j5 - 1) + k4 * 32] == 1)
							enabledSprite.myPixels[j5 + k4 * 32] = k;
						else if (k4 > 0
								&& enabledSprite.myPixels[j5 + (k4 - 1) * 32] == 1)
							enabledSprite.myPixels[j5 + k4 * 32] = k;
						else if (j5 < 31
								&& enabledSprite.myPixels[j5 + 1 + k4 * 32] == 1)
							enabledSprite.myPixels[j5 + k4 * 32] = k;
						else if (k4 < 31
								&& enabledSprite.myPixels[j5 + (k4 + 1) * 32] == 1)
							enabledSprite.myPixels[j5 + k4 * 32] = k;

			}

		} else if (k == 0) {
			for (int k5 = 31; k5 >= 0; k5--) {
				for (int l4 = 31; l4 >= 0; l4--)
					if (enabledSprite.myPixels[k5 + l4 * 32] == 0
							&& k5 > 0
							&& l4 > 0
							&& enabledSprite.myPixels[(k5 - 1) + (l4 - 1) * 32] > 0)
						enabledSprite.myPixels[k5 + l4 * 32] = 0x302020;

			}

		}
		if (itemDef.certTemplateID != -1) {
			int l5 = sprite.maxWidth;
			int j6 = sprite.maxHeight;
			sprite.maxWidth = 32;
			sprite.maxHeight = 32;
			sprite.drawSprite(0, 0);
			sprite.maxWidth = l5;
			sprite.maxHeight = j6;
		}
		if (k == 0)
			mruNodes1.removeFromCache(enabledSprite, i);
		DrawingArea.initDrawingArea(j2, i2, ai1);
		DrawingArea.setDrawingArea(j3, k2, l2, i3);
		Texture.textureInt1 = k1;
		Texture.textureInt2 = l1;
		Texture.anIntArray1472 = ai;
		Texture.aBoolean1464 = true;
		if (itemDef.stackable)
			enabledSprite.maxWidth = 33;
		else
			enabledSprite.maxWidth = 32;
		enabledSprite.maxHeight = j;
		return enabledSprite;
	}

	public Model method201(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];

			if (j != -1)
				return forID(j).method201(1);
		}
		Model model = (Model) mruNodes2.insertFromCache(id);
		if (model != null)
			return model;
		model = Model.method462(modelID);
		if (model == null)
			return null;
		if (anInt167 != 128 || anInt192 != 128 || anInt191 != 128)
			model.method478(anInt167, anInt191, anInt192);
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++)
				model.method476(modifiedModelColors[l], originalModelColors[l]);

		}
		model.method479(64 + anInt196, 768 + anInt184, -50, -10, -50, true);
		model.aBoolean1659 = true;
		mruNodes2.removeFromCache(model, id);
		return model;
	}

	public Model method202(int i) {
		if (stackIDs != null && i > 1) {
			int j = -1;
			for (int k = 0; k < 10; k++)
				if (i >= stackAmounts[k] && stackAmounts[k] != 0)
					j = stackIDs[k];

			if (j != -1)
				return forID(j).method202(1);
		}
		Model model = Model.method462(modelID);
		if (model == null)
			return null;
		if (modifiedModelColors != null) {
			for (int l = 0; l < modifiedModelColors.length; l++)
				model.method476(modifiedModelColors[l], originalModelColors[l]);

		}
		return model;
	}

	private void readValues(Stream stream) {
		do {
			int i = stream.readUnsignedByte();
			if (i == 0)
				return;
			if (i == 1)
				modelID = stream.readUnsignedWord();
			else if (i == 2)
				name = stream.readNewString();
			else if (i == 3)
				description = stream.readBytes();
			else if (i == 4)
				modelZoom = stream.readUnsignedWord();
			else if (i == 5)
				modelRotationY = stream.readUnsignedWord();
			else if (i == 6)
				modelRotationX = stream.readUnsignedWord();
			else if (i == 7) {
				modelOffset1 = stream.readUnsignedWord();
				if (modelOffset1 > 32767)
					modelOffset1 -= 0x10000;
			} else if (i == 8) {
				modelOffset2 = stream.readUnsignedWord();
				if (modelOffset2 > 32767)
					modelOffset2 -= 0x10000;
			} else if (i == 10)
				stream.readUnsignedWord();
			else if (i == 11)
				stackable = true;
			else if (i == 12)
				value = stream.readDWord();
			else if (i == 16)
				membersObject = true;
			else if (i == 23) {
				anInt165 = stream.readUnsignedWord();
				aByte205 = stream.readSignedByte();
			} else if (i == 24)
				anInt188 = stream.readUnsignedWord();
			else if (i == 25) {
				anInt200 = stream.readUnsignedWord();
				aByte154 = stream.readSignedByte();
			} else if (i == 26)
				anInt164 = stream.readUnsignedWord();
			else if (i >= 30 && i < 35) {
				if (groundActions == null)
					groundActions = new String[5];
				groundActions[i - 30] = stream.readNewString();
				if (groundActions[i - 30].equalsIgnoreCase("hidden"))
					groundActions[i - 30] = null;
			} else if (i >= 35 && i < 40) {
				if (itemActions == null)
					itemActions = new String[5];
				itemActions[i - 35] = stream.readNewString();
			} else if(i == 40)
			{
				int j = stream.readUnsignedByte();
				modifiedModelColors = new int[j];
				originalModelColors = new int[j];
				for(int k = 0; k < j; k++)
				{
					modifiedModelColors[k] = stream.readUnsignedWord();
					originalModelColors[k] = stream.readUnsignedWord();
				}
			} else if (i == 78)
				anInt185 = stream.readUnsignedWord();
			else if (i == 79)
				anInt162 = stream.readUnsignedWord();
			else if (i == 90)
				anInt175 = stream.readUnsignedWord();
			else if (i == 91)
				anInt197 = stream.readUnsignedWord();
			else if (i == 92)
				anInt166 = stream.readUnsignedWord();
			else if (i == 93)
				anInt173 = stream.readUnsignedWord();
			else if (i == 95)
				anInt204 = stream.readUnsignedWord();
			else if (i == 97)
				certID = stream.readUnsignedWord();
			else if (i == 98)
				certTemplateID = stream.readUnsignedWord();
			else if (i >= 100 && i < 110) {
				if (stackIDs == null) {
					stackIDs = new int[10];
					stackAmounts = new int[10];
				}
				stackIDs[i - 100] = stream.readUnsignedWord();
				stackAmounts[i - 100] = stream.readUnsignedWord();
			} else if (i == 110)
				anInt167 = stream.readUnsignedWord();
			else if (i == 111)
				anInt192 = stream.readUnsignedWord();
			else if (i == 112)
				anInt191 = stream.readUnsignedWord();
			else if (i == 113)
				anInt196 = stream.readSignedByte();
			else if (i == 114)
				anInt184 = stream.readSignedByte() * 5;
			else if (i == 115)
				team = stream.readUnsignedByte();
		} while (true);
	}

	private ItemDef() {
		id = -1;
	}

	private byte aByte154;
	public int value;// anInt155
	public int[] modifiedModelColors;// modifiedModelColors
	public int id;// anInt157
	static MRUNodes mruNodes1 = new MRUNodes(100);
	public static MRUNodes mruNodes2 = new MRUNodes(50);
	public int[] originalModelColors;
	public boolean membersObject;// aBoolean161
	private int anInt162;
	private int certTemplateID;
	public int anInt164;// femArmModel
	public int anInt165;// maleWieldModel
	private int anInt166;
	private int anInt167;
	public String groundActions[];
	public int modelOffset1;
	public String name;// itemName
	private static ItemDef[] cache;
	private int anInt173;
	public int modelID;// dropModel
	public int femaleEquipOffset;
	public int anInt175;
	public boolean stackable;// itemStackable
	public byte description[];// itemExamine
	public int certID;
	private static int cacheIndex;
	public int modelZoom;
	public static boolean isMembers = true;
	private static Stream stream;
	private int anInt184;
	private int anInt185;
	public int anInt188;// maleArmModel
	public String itemActions[];// itemMenuOption
	public int modelRotationY;// modelRotateUp
	private int anInt191;
	private int anInt192;
	public int[] stackIDs;// modelStack
	public int modelOffset2;//
	private static int[] streamIndices;
	private int anInt196;
	public int anInt197;
	public int modelRotationX;// modelRotateRight
	public int anInt200;// femWieldModel
	public int[] stackAmounts;// itemAmount
	public int team;
	public static int totalItems;
	public int anInt204;// modelPositionUp
	private byte aByte205;

}