public class RSInterface {

	private boolean interfaceShown;

	public void swapInventoryItems(int i, int j) {
		int k = inv[i];
		inv[i] = inv[j];
		inv[j] = k;
		k = invStackSizes[i];
		invStackSizes[i] = invStackSizes[j];
		invStackSizes[j] = k;
	}

	public static void unpack(StreamLoader streamLoader,
			TextDrawingArea textDrawingAreas[], StreamLoader streamLoader_1) {
		aMRUNodes_238 = new MRUNodes(50000);
		Stream stream = new Stream(streamLoader.getDataForName("data"));
		int i = -1;
		int j = stream.readUnsignedWord();
		interfaceCache = new RSInterface[j + 50000];
		while (stream.currentOffset < stream.buffer.length) {
			int k = stream.readUnsignedWord();
			if (k == 65535) {
				i = stream.readUnsignedWord();
				k = stream.readUnsignedWord();
			}
			RSInterface rsInterface = interfaceCache[k] = new RSInterface();
			rsInterface.id = k;
			rsInterface.parentID = i;
			rsInterface.type = stream.readUnsignedByte();
			rsInterface.atActionType = stream.readUnsignedByte();
			rsInterface.contentType = stream.readUnsignedWord();
			rsInterface.width = stream.readUnsignedWord();
			rsInterface.height = stream.readUnsignedWord();
			rsInterface.aByte254 = (byte) stream.readUnsignedByte();
			rsInterface.mOverInterToTrigger = stream.readUnsignedByte();
			if (rsInterface.mOverInterToTrigger != 0)
				rsInterface.mOverInterToTrigger = (rsInterface.mOverInterToTrigger - 1 << 8)
						+ stream.readUnsignedByte();
			else
				rsInterface.mOverInterToTrigger = -1;
			int i1 = stream.readUnsignedByte();
			if (i1 > 0) {
				rsInterface.anIntArray245 = new int[i1];
				rsInterface.anIntArray212 = new int[i1];
				for (int j1 = 0; j1 < i1; j1++) {
					rsInterface.anIntArray245[j1] = stream.readUnsignedByte();
					rsInterface.anIntArray212[j1] = stream.readUnsignedWord();
				}

			}
			int k1 = stream.readUnsignedByte();
			if (k1 > 0) {
				rsInterface.valueIndexArray = new int[k1][];
				for (int l1 = 0; l1 < k1; l1++) {
					int i3 = stream.readUnsignedWord();
					rsInterface.valueIndexArray[l1] = new int[i3];
					for (int l4 = 0; l4 < i3; l4++)
						rsInterface.valueIndexArray[l1][l4] = stream
								.readUnsignedWord();

				}

			}
			if (rsInterface.type == 0) {
				rsInterface.drawsTransparent = false;
				rsInterface.scrollMax = stream.readUnsignedWord();
				rsInterface.isMouseoverTriggered = stream.readUnsignedByte() == 1;
				int i2 = stream.readUnsignedWord();
				rsInterface.children = new int[i2];
				rsInterface.childX = new int[i2];
				rsInterface.childY = new int[i2];
				for (int j3 = 0; j3 < i2; j3++) {
					rsInterface.children[j3] = stream.readUnsignedWord();
					rsInterface.childX[j3] = stream.readSignedWord();
					rsInterface.childY[j3] = stream.readSignedWord();
				}
			}
			if (rsInterface.type == 1) {
				stream.readUnsignedWord();
				stream.readUnsignedByte();
			}
			if (rsInterface.type == 2) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.aBoolean259 = stream.readUnsignedByte() == 1;
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.usableItemInterface = stream.readUnsignedByte() == 1;
				rsInterface.aBoolean235 = stream.readUnsignedByte() == 1;
				rsInterface.invSpritePadX = stream.readUnsignedByte();
				rsInterface.invSpritePadY = stream.readUnsignedByte();
				rsInterface.spritesX = new int[20];
				rsInterface.spritesY = new int[20];
				rsInterface.sprites = new Sprite[20];
				for (int j2 = 0; j2 < 20; j2++) {
					int k3 = stream.readUnsignedByte();
					if (k3 == 1) {
						rsInterface.spritesX[j2] = stream.readSignedWord();
						rsInterface.spritesY[j2] = stream.readSignedWord();
						String s1 = stream.readString();
						if (streamLoader_1 != null && s1.length() > 0) {
							int i5 = s1.lastIndexOf(",");
							rsInterface.sprites[j2] = method207(
									Integer.parseInt(s1.substring(i5 + 1)),
									streamLoader_1, s1.substring(0, i5));
						}
					}
				}
				rsInterface.actions = new String[5];
				for (int l3 = 0; l3 < 5; l3++) {
					rsInterface.actions[l3] = stream.readString();
					if (rsInterface.actions[l3].length() == 0)
						rsInterface.actions[l3] = null;
					if (rsInterface.parentID == 3824)
						rsInterface.actions[4] = "Buy X";
					if (rsInterface.parentID == 3822)
						rsInterface.actions[4] = "Sell X";
					if (rsInterface.parentID == 1644)
						rsInterface.actions[2] = "Operate";
				}
			}
			if (rsInterface.type == 3)
				rsInterface.aBoolean227 = stream.readUnsignedByte() == 1;
			if (rsInterface.type == 4 || rsInterface.type == 1) {
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int k2 = stream.readUnsignedByte();
				if (textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[k2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
			}
			if (rsInterface.type == 4) {
				rsInterface.message = stream.readString();
				rsInterface.aString228 = stream.readString();
			}
			if (rsInterface.type == 1 || rsInterface.type == 3
					|| rsInterface.type == 4)
				rsInterface.textColor = stream.readDWord();
			if (rsInterface.type == 3 || rsInterface.type == 4) {
				rsInterface.anInt219 = stream.readDWord();
				rsInterface.anInt216 = stream.readDWord();
				rsInterface.anInt239 = stream.readDWord();
			}
			if (rsInterface.type == 5) {
				rsInterface.drawsTransparent = false;
				String s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int i4 = s.lastIndexOf(",");
					rsInterface.sprite1 = method207(
							Integer.parseInt(s.substring(i4 + 1)),
							streamLoader_1, s.substring(0, i4));
				}
				s = stream.readString();
				if (streamLoader_1 != null && s.length() > 0) {
					int j4 = s.lastIndexOf(",");
					rsInterface.sprite2 = method207(
							Integer.parseInt(s.substring(j4 + 1)),
							streamLoader_1, s.substring(0, j4));
				}
			}
			if (rsInterface.type == 6) {
				int l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt233 = 1;
					rsInterface.mediaID = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0) {
					rsInterface.anInt255 = 1;
					rsInterface.anInt256 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				}
				l = stream.readUnsignedByte();
				if (l != 0)
					rsInterface.anInt257 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				else
					rsInterface.anInt257 = -1;
				l = stream.readUnsignedByte();
				if (l != 0)
					rsInterface.anInt258 = (l - 1 << 8)
							+ stream.readUnsignedByte();
				else
					rsInterface.anInt258 = -1;
				rsInterface.modelZoom = stream.readUnsignedWord();
				rsInterface.modelRotation1 = stream.readUnsignedWord();
				rsInterface.modelRotation2 = stream.readUnsignedWord();
			}
			if (rsInterface.type == 7) {
				rsInterface.inv = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.invStackSizes = new int[rsInterface.width
						* rsInterface.height];
				rsInterface.centerText = stream.readUnsignedByte() == 1;
				int l2 = stream.readUnsignedByte();
				if (textDrawingAreas != null)
					rsInterface.textDrawingAreas = textDrawingAreas[l2];
				rsInterface.textShadow = stream.readUnsignedByte() == 1;
				rsInterface.textColor = stream.readDWord();
				rsInterface.invSpritePadX = stream.readSignedWord();
				rsInterface.invSpritePadY = stream.readSignedWord();
				rsInterface.isInventoryInterface = stream.readUnsignedByte() == 1;
				rsInterface.actions = new String[5];
				for (int k4 = 0; k4 < 5; k4++) {
					rsInterface.actions[k4] = stream.readString();
					if (rsInterface.actions[k4].length() == 0)
						rsInterface.actions[k4] = null;
				}

			}
			if (rsInterface.atActionType == 2 || rsInterface.type == 2) {
				rsInterface.selectedActionName = stream.readString();
				rsInterface.spellName = stream.readString();
				rsInterface.spellUsableOn = stream.readUnsignedWord();
			}

			if (rsInterface.type == 8)
				rsInterface.message = stream.readString();

			if (rsInterface.atActionType == 1 || rsInterface.atActionType == 4
					|| rsInterface.atActionType == 5
					|| rsInterface.atActionType == 6) {
				rsInterface.tooltip = stream.readString();
				if (rsInterface.tooltip.length() == 0) {
					if (rsInterface.atActionType == 1)
						rsInterface.tooltip = "Ok";
					if (rsInterface.atActionType == 4)
						rsInterface.tooltip = "Select";
					if (rsInterface.atActionType == 5)
						rsInterface.tooltip = "Select";
					if (rsInterface.atActionType == 6)
						rsInterface.tooltip = "Continue";
				}
			}
		}
		aClass44 = streamLoader;
		fonts = textDrawingAreas;
		NewSkillTab(rsFonts);
		//skillTab602(textDrawingAreas);
		summoningTab(textDrawingAreas);
		//petSummoningTab(textDrawingAreas);
		questTab(textDrawingAreas);
		barrowText(textDrawingAreas);
		pouchCreation(textDrawingAreas);
		scrollCreation(textDrawingAreas);
		pouches(textDrawingAreas);
		bankPin(textDrawingAreas);
		bank(textDrawingAreas);
		ironmanInformation(textDrawingAreas);
		ironmanInterface(textDrawingAreas);
		itemsKeptOnDeath(textDrawingAreas);
		itemsOnDeathDATA(textDrawingAreas);
		//itemsOnDeath(textDrawingAreas);
		equipmentTab(textDrawingAreas);
		GodWars(textDrawingAreas);
		Pestpanel(textDrawingAreas);
		Pestpanel2(textDrawingAreas);
		Interfaces.loadInterfaces(streamLoader, textDrawingAreas);
		
		aMRUNodes_238 = null;
	}
	public static void Pestpanel(TextDrawingArea[] tda) {
		RSInterface Interface = addInterface(21119);
		addText(21120, "XXX", 0x999999, false, true, 52, tda, 1);
		addText(21121, "XXX", 0x33cc00, false, true, 52, tda, 1);
		addText(21122, "XXX", 0xFFcc33, false, true, 52, tda, 1);
		addText(21123, "XXX", 0x33ccff, false, true, 52, tda, 1);
		int last = 4;
		Interface.children = new int[last];
		Interface.childX = new int[last];
		Interface.childY = new int[last];
		setBounds(21120, 15, 12, 0, Interface);
		setBounds(21121, 15, 30, 1, Interface);
		setBounds(21122, 15, 48, 2, Interface);
		setBounds(21123, 15, 66, 3, Interface);
	}

	public static void Pestpanel2(TextDrawingArea[] tda) {
		RSInterface Interface = addInterface(21100);
		addSprite(21101, 0, "Interfaces/Pest Control/PEST1");
		addSprite(21102, 1, "Interfaces/Pest Control/PEST1");
		addSprite(21103, 2, "Interfaces/Pest Control/PEST1");
		addSprite(21104, 3, "Interfaces/Pest Control/PEST1");
		addSprite(21105, 4, "Interfaces/Pest Control/PEST1");
		addSprite(21106, 5, "Interfaces/Pest Control/PEST1");
		addText(21107, "", 0xCC00CC, false, true, 52, tda, 1);
		addText(21108, "", 0x0000FF, false, true, 52, tda, 1);
		addText(21109, "", 0xFFFF44, false, true, 52, tda, 1);
		addText(21110, "", 0xCC0000, false, true, 52, tda, 1);
		addText(21111, "250", 0x99FF33, false, true, 52, tda, 1);// w purp
		addText(21112, "250", 0x99FF33, false, true, 52, tda, 1);// e blue
		addText(21113, "250", 0x99FF33, false, true, 52, tda, 1);// se yel
		addText(21114, "250", 0x99FF33, false, true, 52, tda, 1);// sw red
		addText(21115, "200", 0x99FF33, false, true, 52, tda, 1);// attacks
		addText(21116, "0", 0x99FF33, false, true, 52, tda, 1);// knights hp
		addText(21117, "Time Remaining:", 0xFFFFFF, false, true, 52, tda, 0);
		addText(21118, "", 0xFFFFFF, false, true, 52, tda, 0);
		int last = 18;
		Interface.children = new int[last];
		Interface.childX = new int[last];
		Interface.childY = new int[last];
		setBounds(21101, 361, 26, 0, Interface);
		setBounds(21102, 396, 26, 1, Interface);
		setBounds(21103, 436, 26, 2, Interface);
		setBounds(21104, 474, 26, 3, Interface);
		setBounds(21105, 3, 21, 4, Interface);
		setBounds(21106, 3, 50, 5, Interface);
		setBounds(21107, 371, 60, 6, Interface);
		setBounds(21108, 409, 60, 7, Interface);
		setBounds(21109, 443, 60, 8, Interface);
		setBounds(21110, 479, 60, 9, Interface);
		setBounds(21111, 362, 10, 10, Interface);
		setBounds(21112, 398, 10, 11, Interface);
		setBounds(21113, 436, 10, 12, Interface);
		setBounds(21114, 475, 10, 13, Interface);
		setBounds(21115, 32, 32, 14, Interface);
		setBounds(21116, 32, 62, 15, Interface);
		setBounds(21117, 8, 88, 16, Interface);
		setBounds(21118, 87, 88, 17, Interface);
	}
	
	public static void GodWars(TextDrawingArea[] TDA) {
		RSInterface rsinterface = addInterface(16210);
		addText(16211, "NPC Killcount", TDA, 0, 0xff9040);
		addText(16212, "Armadyl kills", TDA, 0, 0xff9040);
		addText(16213, "Bandos kills", TDA, 0, 0xff9040);
		addText(16214, "Saradomin kills", TDA, 0, 0xff9040);
		addText(16215, "Zamorak kills", TDA, 0, 0xff9040);
		addText(16216, "", TDA, 0, 0x66FFFF);//armadyl
		addText(16217, "", TDA, 0, 0x66FFFF);//bandos
		addText(16218, "", TDA, 0, 0x66FFFF);//saradomin
		addText(16219, "", TDA, 0, 0x66FFFF);//zamorak
		rsinterface.scrollMax = 0;
		rsinterface.children = new int[9];
		rsinterface.childX = new int[9];
		rsinterface.childY = new int[9];
		rsinterface.children[0] = 16211;
		//if (Client.frameMode == Client.ScreenMode.FIXED) { //NPC Killcount	
		//rsinterface.childX[0] = Client.frameWidth + 15;		rsinterface.childY[0] = 5;
		//} else if (Client.frameMode == Client.ScreenMode.RESIZABLE) {
		rsinterface.childX[0] = -52+375+30;		rsinterface.childY[0] = 7;
		//}
		rsinterface.children[1] = 16212; //arma
			rsinterface.childX[1] = -52+375+30;		rsinterface.childY[1] = 30;
			
		rsinterface.children[2] = 16213;
			rsinterface.childX[2] = -52+375+30;		rsinterface.childY[2] = 44;
			
		rsinterface.children[3] = 16214;
		rsinterface.childX[3] = -52+375+30;		rsinterface.childY[3] = 58;
		
		rsinterface.children[4] = 16215;
		rsinterface.childX[4] = -52+375+30;		rsinterface.childY[4] = 73;
		
		rsinterface.children[5] = 16216;//arma
		rsinterface.childX[5] = -52+460+60;		rsinterface.childY[5] = 31;
		
		rsinterface.children[6] = 16217;
		rsinterface.childX[6] = -52+460+60;		rsinterface.childY[6] = 45;
		
		rsinterface.children[7] = 16218;
		rsinterface.childX[7] = -52+460+60;		rsinterface.childY[7] = 59;
		
		rsinterface.children[8] = 16219;
		rsinterface.childX[8] = -52+460+60;		rsinterface.childY[8] = 74;
	}
	public static void bank(TextDrawingArea[] wid) {
                RSInterface Interface = addTabInterface(24959);
                setChildren(46, Interface);
                addSprite(5293, 0, "Interfaces/Bank/BANK");
                setBounds(5293, 13, 1, 0, Interface);
                addHover(5384, 3, 0, 5380, 1, "Interfaces/Bank/BANK", 25, 25,
                                "Close Window");
                //
                addHovered(5380, 2, "Interfaces/Bank/BANK", 25, 25, 5379);
                setBounds(5384, 472, 8, 3, Interface);
                setBounds(5380, 472, 8, 4, Interface);
                //
 
                addText(24049, "Insert", wid, 1, 16750623, true, true);
                setBounds(24049, 125, 307, 43, Interface);
 
                setBounds(8131, 89, 298, 5, Interface);// Insert
                setBounds(0, 9000, 9000, 6, Interface);
                addText(24047, "Swap", wid, 1, 16750623, true, true);
                setBounds(24047, 54, 307, 44, Interface);
                setBounds(8130, 19, 298, 7, Interface);// Swap
                setBounds(0, 9000, 9000, 8, Interface);
                setBounds(5387, 212, 298, 9, Interface);// item
                setBounds(5386, 282, 298, 10, Interface);// Note
                setBounds(0, 9000, 9000, 11, Interface);
                addText(24055, "Note", wid, 1, 16750623, true, true);
                setBounds(24055, 316, 307, 45, Interface);
 
                addBankHover1(22012, 5, 22013, 17, "Interfaces/Bank/BANK", 36, 36,
                                "Search", 22014, 18, "Bank/BANK", 22015,
                                "Empty your backpack into\nyour bank", 0, 20);
                setBounds(0, 9000, 9000, 12, Interface);
                setBounds(0, 9000, 9000, 13, Interface);
 
                addBankHover1(22016, 5, 22017, 19, "Interfaces/Bank/BANK", 36, 36,
                                "Deposit Inventory", 23018, 20, "Bank/BANK", 23019,
                                "Empty the items your are\nwearing into your bank", 0, 20);
                setBounds(22016, 423, 290, 14, Interface);
                setBounds(22017, 423, 290, 15, Interface);
                addBankHover1(23020, 5, 23021, 21, "Interfaces/Bank/BANK", 36, 36,
                                "Deposit Equipment", 23022, 22, "Bank/BANK", 23023,
                                "Empty your BoB's inventory\ninto your bank", 0, 20);
                setBounds(23020, 459, 290, 16, Interface);
                setBounds(23021, 459, 290, 17, Interface);
                setBounds(5383, 195, 11, 1, Interface);
                setBounds(5385, 27, 78, 2, Interface);
 
                addText(24046, "Item", wid, 1, 16750623, true, true);
                setBounds(24046, 248, 307, 42, Interface);
 
                addButton(24004, 1, " ", " ");
                setBounds(24004, 387, 290, 41, Interface);
 
                addButton(22024, 0, "Interfaces/BANK/TAB", "View Bank");
                setBounds(22024, 57, 36, 18, Interface);

                addButton(22025, 4, " ", " ");
                setBounds(22025, 97, 37, 19, Interface);
                addButton(22026, 4, " ", " ");
                setBounds(22026, 137, 37, 20, Interface);
                addButton(22027, 4, " ", " ");
                setBounds(22027, 177, 37, 21, Interface);
                addButton(22028, 4, " ", " ");
                setBounds(22028, 217, 37, 22, Interface);
                addButton(22029, 4, " ", " ");
                setBounds(22029, 257, 37, 23, Interface);
                addButton(22030, 4, " ", " ");
                setBounds(22030, 297, 37, 24, Interface);
                addButton(22031, 4, " ", " ");
                setBounds(22031, 337, 37, 25, Interface);
                addButton(22032, 4, " ", " ");
                setBounds(22032, 377, 37, 26, Interface);
                addText(22033, " ", wid, 0, 16750623, true, true);
                setBounds(22033, 30, 7, 27, Interface);
                addText(22034, " ", wid, 0, 16750623, true, true);
                setBounds(22034, 30, 19, 28, Interface);
                addBankItem(22035, false);
                setBounds(22035, 102, 40, 29, Interface);
                addBankItem(22036, false);
                setBounds(22036, 142, 40, 30, Interface);
                addBankItem(22037, false);
                setBounds(22037, 182, 40, 31, Interface);
                addBankItem(22038, false);
                setBounds(22038, 222, 40, 32, Interface);
                addBankItem(22039, false);
                setBounds(22039, 262, 40, 33, Interface);
                addBankItem(22040, false);
                setBounds(22040, 302, 40, 34, Interface);
                addBankItem(22041, false);
                setBounds(22041, 342, 40, 35, Interface);
                addBankItem(22042, false);
                setBounds(22042, 382, 40, 36, Interface);
 
                addText(27000, "0", 16750623, false, true, 52, wid, 1);
                addText(27001, "0", 16750623, false, true, 52, wid, 1);
                addText(27002, "0", 16750623, false, true, 52, wid, 1);
                addText(22043, " ", wid, 0, 16750623, true, true);
                setBounds(22043, 30, 10, 37, Interface);
                addSprite(22044, 24, "Interfaces/Bank/BANK");
                setBounds(22044, 463, 42, 38, Interface);
                addText(22045, "Withdraw as:", wid, 1, 16750623, true, true);
                setBounds(22045, 283, 290, 39, Interface);
                addText(22046, "Rearrange mode:", wid, 1, 16750623, true, true);
                setBounds(22046, 102, 290, 40, Interface);
                Interface = interfaceCache[5385];
                Interface.height = 206;
                Interface.width = 452;
                Interface = interfaceCache[5382];
                Interface.width = 8;
                Interface.invSpritePadX = 17;
                Interface.height = 35;
 
        }

		
		 public static void addBankItem(int index, Boolean hasOption) {
  RSInterface rsi = interfaceCache[index] = new RSInterface();
  rsi.actions = new String[5];
  rsi.spritesX = new int[20];
  rsi.invStackSizes = new int[30];
  rsi.inv = new int[30];
  rsi.spritesY = new int[20];

  rsi.children = new int[0];
  rsi.childX = new int[0];
  rsi.childY = new int[0];

  rsi.hasExamine = false;

  rsi.invSpritePadX = 24;
  rsi.invSpritePadY = 24;
  rsi.height = 5;
  rsi.width = 6;
  rsi.parentID = 24959;
  rsi.id = index;
  rsi.type = 13;
 }
 
 	public int transparency;
 
 public static void addTransparentSprite(int id, int spriteId,
			String spriteName, int transparency) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.transparency = (byte) transparency;
		tab.hoverType = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}
	
	public static void ironmanInformation(TextDrawingArea[] tda) {
		RSInterface rsi = addInterface(51000);
		addSprite(51001, 10, "Interfaces/Options/SPRITE");
		addSprite(51002, 4, "Interfaces/Options/SPRITE");
		addSprite(51003, 4, "Interfaces/Options/SPRITE");
		addHoverButton(51004, "Interfaces/Options/SPRITE", 2, 16, 16, "Close",
				375, 51005, 3);
		addHoveredButton(51005, "Interfaces/Options/SPRITE", 3, 16, 16, 51006);
		addText(51007, "Iron Man Mode Option Box", tda, 2, 0xCCFF66, true);
		addText(51008,
				"Here is where you begin your adventure.", tda,
				0, 0xCCFF66, false);
		addText(51009, "You now have to make the decision on a game mode.", tda, 0, 0xCCFF66, false);
		addText(51010, "Accept = Iron Man & Decline = Normal Player.", tda, 0,
				0xCCFF66, false);
		addHoverButton(51011, "Interfaces/Options/SPRITE", 7, 76, 20, "Accept",
				205, 51012, 1);
		addHoveredButton(51012, "Interfaces/Options/SPRITE", 8, 76, 20, 51013);
		addText(51014, "Accept", tda, 1, 0xCCFF66, false);
		addHoverButton(51015, "Interfaces/Options/SPRITE", 7, 76, 20,
				"Decline", 205, 51016, 1);
		addHoveredButton(51016, "Interfaces/Options/SPRITE", 8, 76, 20, 51017);
		addText(51018, "Decline", tda, 1, 0xCCFF66, false);
		addHoverButton(51019, "", 11, 20, 20,
				"", 205, 51020, 1);
		addHoveredButton(51020, "", 12, 20, 20, 51021);
		setChildren(18, rsi);
		setBounds(51001, 120, 62, 0, rsi);
		setBounds(51002, 127, 130, 1, rsi);
		setBounds(51003, 127, 240, 2, rsi);
		setBounds(51025, 127, 132, 3, rsi);
		setBounds(51004, 370, 65, 4, rsi);
		setBounds(51005, 370, 65, 5, rsi);
		setBounds(51007, 512 / 2 - 5, 65, 6, rsi);
		setBounds(51008, 128, 86, 7, rsi);
		setBounds(51009, 128, 101, 8, rsi);
		setBounds(51010, 128, 116, 9, rsi);
		setBounds(51011, 177, 250, 10, rsi);
		setBounds(51012, 177, 250, 11, rsi);
		setBounds(51014, 195, 251, 12, rsi);
		setBounds(51015, 257, 250, 13, rsi);
		setBounds(51016, 257, 250, 14, rsi);
		setBounds(51018, 275, 251, 15, rsi);
		setBounds(51019, 365, 255, 16, rsi);
		setBounds(51020, 365, 255, 17, rsi);

		RSInterface scroll = addInterface(51025);
		scroll.width = 243;
		scroll.height = 108;
		scroll.scrollMax = 118;
		setChildren(8, scroll);
		addText(51026, "Iron-Man Restrictions", tda, 2, 0xCCFF66, true);
		addText(51027, "1. You can't trade.", tda, 0, 0xCCFF66,
				false);
		addText(51028, "2. You can duel but can't stake items.", tda, 0,
				0xCCFF66, false);
		addText(51029, "3. You can't see the drops of other players.", tda, 0,
				0xCCFF66, false);
		addText(51030, "4. You can only access a limted selection of shops.", tda, 0,
				0xCCFF66, false);
		addText(51031, "5. You can't pick up any drops from Pking.", tda, 0,
				0xCCFF66, false);
		addText(51032, "", tda, 0,
				0xCCFF66, false);
		addText(51033, "Thanks and Goodluck!", tda,
				0, 0xCCFF66, false);
		setBounds(51026, 120, 3, 0, scroll);
		setBounds(51027, 1, 20, 1, scroll);
		setBounds(51028, 1, 34, 2, scroll);
		setBounds(51029, 1, 48, 3, scroll);
		setBounds(51030, 1, 62, 4, scroll);
		setBounds(51031, 1, 76, 5, scroll);
		setBounds(51032, 1, 90, 6, scroll);
		setBounds(51033, 1, 104, 7, scroll);
	}
	
	 private static void ironmanInterface(TextDrawingArea[] tda)
  {
    RSInterface rs = addInterface(42400);
    addSprite(42401, 1, "Interfaces/Ironman/IMAGE");
    //a(42402, "Toggle", "Interfaces/Ironman/IMAGE", new int[] { 2, 3, 4 });
    //a(42403, "Toggle", "Interfaces/Ironman/IMAGE", new int[] { 2, 3, 4 });
    //a(42404, "Toggle", "Interfaces/Ironman/IMAGE", new int[] { 2, 3, 4 });
    //a(42405, "Toggle", "Interfaces/Ironman/IMAGE", new int[] { 2, 3, 4 });
    //a(42406, "Toggle", "Interfaces/Ironman/IMAGE", new int[] { 2, 3, 4 });
    /*addText(42407, "An Iron Man does not receive items or assistance from other players.\\nThey cannot trade, stake, receive PK loot, scavenge dropped items,\\nnor play certain multiplayer minigames.", tda, 0, 16614682, false, true);
    addText(42408, "In addition to the standard Iron Man rules, an Ultimate Iron Man\\ncannot use banks, nor retain any items on death in dangerous areas.", tda, 0, 16614682, false, true);
    addText(42409, "No Iron Man restrictions will apply to this account.", tda, 0, 16614682, false, true);
    addText(42410, "You must talk to an npc that will reset your mode after a seven day\\ndelay.", tda, 0, 16614682, false, true);
    addText(42411, "The Iron Man restrictions can never be removed.", tda, 0, 16614682, false, true);
    addText(42412, "Standard Iron Man", tda, 0, 16777215, false, true);
    addText(42413, "Ultimate Iron Man", tda, 0, 16777215, false, true);
    addText(42414, "None", tda, 0, 16777215, false, true);
    addText(42415, "NPC", tda, 0, 16777215, false, true);
    addText(42416, "Permanent", tda, 0, 16777215, false, true);
    addText(42417, "Iron Man Mode", tda, 1, 16777215, false, true);
    addText(42418, "After Selection...", tda, 1, 16777215, false, true);
    //addText(42419, "Interfaces/Ironman/IMAGE", 5, 23, 23, "Confirm and Continue", 0, 42420, 1);
    //addText(42420, "Interfaces/Ironman/IMAGE", 6, 23, 23, 42421);
    setChildren(20, rs);
    setBounds(42401, 15, 28, 0, rs);
    setBounds(42402, 30, 104, 1, rs);
    setBounds(42403, 30, 152, 2, rs);
    setBounds(42404, 30, 185, 3, rs);
    setBounds(42405, 110, 244, 4, rs);
    setBounds(42406, 110, 277, 5, rs);
    setBounds(42407, 50, 102, 6, rs);
    setBounds(42408, 50, 154, 7, rs);
    setBounds(42409, 86, 187, 8, rs);
    setBounds(42410, 130, 241, 9, rs);
    setBounds(42411, 194, 279, 10, rs);
    setBounds(42412, 50, 92, 11, rs);
    setBounds(42413, 50, 144, 12, rs);
    setBounds(42414, 50, 187, 13, rs);
    setBounds(42415, 130, 231, 14, rs);
    setBounds(42416, 130, 279, 15, rs);
    setBounds(42417, 174, 69, 16, rs);
    setBounds(42418, 250, 210, 17, rs);
    setBounds(42419, 465, 34, 18, rs);
    setBounds(42420, 465, 34, 19, rs);*/
  }
	
	/**
	 * Start of Bank
	 */
	/*public static void bank(TextDrawingArea[] tda) {
		RSInterface rs = addInterface(5292);
		rs.message = "";
		setChildren(28, rs);
		addSprite(58001, 0, "BankTab/BANK");
		addHoverButton(5384, "BankTab/BANK", 1, 24, 24, "Close Window", 250,
				5380, 3);
		addHoveredButton(5380, "BankTab/BANK", 2, 24, 24, 5379);
		addHoverButton(5294, "BankTab/BANK", 3, 100, 33, "Set A Bank PIN", 250,
				5295, 4);
		addHoveredButton(5295, "BankTab/BANK", 4, 100, 33, 5296);
		addBankHover(58002, 4, 58003, 5, 8, "BankTab/BANK", 37, 29, 304, 1,
				"Swap Withdraw Mode", 58004, 7, 6, "BankTab/BANK", 58005,
				"",
				"", 12, 20);
		addBankHover(58010, 4, 58011, 9, 11, "BankTab/BANK", 37, 29, 115, 1,
				"Swap Withdrawal Mode", 58012, 10, 12, "BankTab/BANK", 58013,
				"",
				"", 12, 20);
		addBankHover1(58018, 5, 58019, 17, "BankTab/BANK", 37, 29,
				"Deposit carried items", 58020, 18, "BankTab/BANK", 58021,
				"", 0, 20);
		addBankHover1(58026, 5, 58027, 19, "BankTab/BANK", 35, 25,
				"Deposit worn items", 58028, 20, "BankTab/BANK", 58029,
				"", 0, 20);
		for (int i = 0; i < 9; i++) {
			addInterface(58050 + i);
			if (i == 0)
				addConfigButton(58031, 5292, 1, 0, "BankTab/TAB", 48, 38,
						new String[] { "Price Check", "View" }, 1, 700);
			else
				addConfigButton(58031 + i, 5292, 4, 2, "BankTab/TAB", 48, 38,
						new String[] { "Price Check", "Collapse", "View" }, 1,
						700 + i);
			addToItemGroup(58040 + i, 1, 1, 0, 0, false, "", "", "");
		}
		addSprite(58060, 21, "BankTab/BANK");
		addText(58061, "0", tda, 0, 0xE68A00, true, true);
		addText(58062, "350", tda, 0, 0xE68A00, true, true);
		addInputField(58063, 50, 0xE68A00, "Search", 132, 23, false, true);
		addText(58064, "Jason's Bank", tda, 1, 0xE68A00, true, true);
		RSInterface Interface = interfaceCache[5385];
		Interface.height = 208;
		Interface.width = 481;
		Interface = interfaceCache[5382];
		Interface.width = 10;
		Interface.invSpritePadX = 12;
		Interface.height = 35;
		Interface.actions = new String[] { "Withdraw 1", "Withdraw 5",
				"Withdraw 10", "Withdraw All", "Withdraw X",
				"Withdraw All but one" };
		setBounds(58001, 13, 1, 0, rs);
		setBounds(5384, 475, 10, 1, rs);
		setBounds(5380, 475, 10, 2, rs);
		setBounds(5294, 193, 297, 3, rs);
		setBounds(5295, 193, 297, 4, rs);
		setBounds(58002, 25, 297, 5, rs);
		setBounds(58003, 10, 237, 6, rs);
		setBounds(58010, 67, 297, 7, rs);
		setBounds(58011, 52, 237, 8, rs);

		setBounds(58018, 109, 297, 9, rs);
		setBounds(58019, 94, 237, 10, rs);
		setBounds(58026, 151, 297, 11, rs);
		setBounds(58027, 136, 237, 12, rs);
		setBounds(5385, -3, 76, 13, rs);
		RSInterface.interfaceCache[5385].height = 216;
		int x = 68;
		for (int i = 0; i < 9; i++) {
			setBounds(58050 + i, 0, 0, 14 + i, rs);
			RSInterface rsi = interfaceCache[58050 + i];
			setChildren(2, rsi);
			setBounds(58031 + i, x, 36, 0, rsi);
			setBounds(58040 + i, x + 5, 39, 1, rsi);
			x += 41;
		}
		setBounds(58060, 452, 295, 23, rs);
		setBounds(58061, 473, 299, 24, rs);
		setBounds(58062, 473, 310, 25, rs);
		setBounds(58063, 315, 298, 26, rs);
		setBounds(58064, 250, 11, 27, rs);
	}

	public static void addToItemGroup(int id, int w, int h, int x, int y,
			boolean actions, String action1, String action2, String action3) {
		RSInterface rsi = addInterface(id);
		rsi.width = w;
		rsi.height = h;
		rsi.inv = new int[w * h];
		rsi.invStackSizes = new int[w * h];
		rsi.usableItemInterface = false;
		rsi.isInventoryInterface = false;
		rsi.invisible = false;
		rsi.invSpritePadX = x;
		rsi.invSpritePadY = y;
		rsi.spritesX = new int[20];
		rsi.spritesY = new int[20];
		rsi.sprites = new Sprite[20];
		rsi.actions = new String[5];
		if (actions) {
			rsi.actions[0] = action1;
			rsi.actions[1] = action2;
			rsi.actions[2] = action3;
		}
		rsi.type = 2;
	}*/

	public static void addBankHover1(int interfaceID, int actionType,
			int hoverid, int spriteId, String NAME, int Width, int Height,
			String Tooltip, int hoverId2, int hoverSpriteId,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.opacity = 0;
		hover.hoverType = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.invisible = true;
		hover.hoverType = -1;
		addSprites(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName, 0,
				0);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText,
				hoverDisabledText, 0, 0);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}


	public static void addBankHover(int interfaceID, int actionType,
			int hoverid, int spriteId, int spriteId2, String NAME, int Width,
			int Height, int configFrame, int configId, String Tooltip,
			int hoverId2, int hoverSpriteId, int hoverSpriteId2,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			String hoverEnabledText, int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.opacity = 0;
		hover.hoverType = hoverid;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.sprite2 = imageLoader(spriteId2, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover.anIntArray245 = new int[1];
		hover.anIntArray212 = new int[1];
		hover.anIntArray245[0] = 1;
		hover.anIntArray212[0] = configId;
		hover.valueIndexArray = new int[1][3];
		hover.valueIndexArray[0][0] = 5;
		hover.valueIndexArray[0][1] = configFrame;
		hover.valueIndexArray[0][2] = 0;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.invisible = true;
		hover.hoverType = -1;
		addSprites(hoverId2, hoverSpriteId, hoverSpriteId2, hoverSpriteName,
				configId, configFrame);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText, hoverEnabledText,
				configId, configFrame);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}

	public static void addSprites(int ID, int i, int i2, String name,
			int configId, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 5;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 512;
		Tab.height = 334;
		Tab.opacity = (byte) 0;
		Tab.hoverType = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configId;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(i, name);
		Tab.sprite2 = imageLoader(i2, name);
	}

	public static void addConfigButton(int ID, int pID, int bID, int bID2,
			String bName, int width, int height, String[] tooltips,
			int configID, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = 8;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.opacity = 0;
		Tab.hoverType = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(bID, bName);
		Tab.sprite2 = imageLoader(bID2, bName);
		Tab.tooltips = tooltips;
	}
	
	
	public static void bankPin(TextDrawingArea[] wid) {
		RSInterface tab = addInterface(59500);
		addSprite(59501, 0, "Interfaces/Bankpin/IMAGE");
		addText(59502, "Account Pin", wid, 2, 0xFF981F, true, true);
		addText(59503, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59504, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59505, "Enter your 4 digit code", wid, 1, 0xFF981F, true, true);
		addText(59506, "Press enter to submit", wid, 2, 0xFF981F, true, true);
		addInputField(59507, 8, 0xFF981F, "", 100, 24, true);
		addHoverButton(59508, "Interfaces/Bankpin/IMAGE", 1, 16, 16, "Close",
				375, 59509, 3);
		addHoveredButton(59509, "Interfaces/Bankpin/IMAGE", 2, 16, 16, 59510);
		setChildren(9, tab);
		setBounds(59501, 256 - 140, 120, 0, tab);
		setBounds(59502, 256, 132, 1, tab);
		setBounds(59503, 256, 150, 2, tab);
		setBounds(59504, 256, 165, 3, tab);
		setBounds(59505, 256, 180, 4, tab);
		setBounds(59506, 256, 200, 5, tab);
		setBounds(59507, 256 - 50, 220, 6, tab);
		setBounds(59508, 374, 127, 7, tab);
		setBounds(59509, 374, 127, 8, tab);
	}
	public static void addInputField(int identity, int characterLimit,
			int color, String text, int width, int height, boolean asterisks,
			boolean updatesEveryInput, String regex) {
		RSInterface field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.tooltips = new String[] { "Clear", "Edit" };
		field.defaultInputFieldText = text;
		field.updatesEveryInput = updatesEveryInput;
		field.inputRegex = regex;
	}

	public static void addInputField(int identity, int characterLimit,
			int color, String text, int width, int height, boolean asterisks,
			boolean updatesEveryInput) {
		RSInterface field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.defaultInputFieldText = text;
		field.tooltips = new String[] { "Clear", "Edit" };
		field.updatesEveryInput = updatesEveryInput;
	}

	public static void addInputField(int identity, int characterLimit,
			int color, String text, int width, int height, boolean asterisks) {
		RSInterface field = addFullScreenInterface(identity);
		field.id = identity;
		field.type = 16;
		field.atActionType = 8;
		field.message = text;
		field.width = width;
		field.height = height;
		field.characterLimit = characterLimit;
		field.textColor = color;
		field.displayAsterisks = asterisks;
		field.defaultInputFieldText = text;
		field.tooltips = new String[] { "Clear", "Edit" };
	}
	public static RSInterface addFullScreenInterface(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentID = id;
		rsi.width = 765;
		rsi.height = 503;
		return rsi;
	}
	public boolean invisible;
	public boolean hasExamine = true;
	public String[] tooltips;
	String defaultInputFieldText = "";
	boolean displayAsterisks;
	public int characterLimit;
	public static int currentInputFieldId;
	public boolean isInFocus;
	String inputRegex = "";
	boolean updatesEveryInput;
	/**
	 * End of Bank
	 */
	
	public static void barrowText(TextDrawingArea[] tda) {
        RSInterface tab = addScreenInterface(16128);
        addText(16129, "Barrows Brothers", tda, 2, 0xff981f, true, true);
        addText(16130, "Dharoks", tda, 1, 0x86B404, true, true);
        addText(16131, "Veracs", tda, 1, 0x86B404, true, true);
        addText(16132, "Ahrims", tda, 1, 0x86B404, true, true);
        addText(16133, "Torags", tda, 1, 0x86B404, true, true);
        addText(16134, "Guthans", tda, 1, 0x86B404, true, true);
        addText(16135, "Karils", tda, 1, 0x86B404, true, true);
        addText(16136, "Killcount:", tda, 2, 0xff981f, true, true);
        addText(16137, "#", tda, 1, 0x86B404, true, true);
        tab.totalChildren(9);
        tab.child(0, 16129, 452, 220);
        tab.child(1, 16130, 460, 240);
        tab.child(2, 16131, 460, 255);
        tab.child(3, 16132, 460, 270);
        tab.child(4, 16133, 460, 285);
        tab.child(5, 16134, 460, 300);
        tab.child(6, 16135, 460, 315);
        tab.child(7, 16136, 30, 318);
        tab.child(8, 16137, 68, 318);
    }
	
	
	public static void pouches(TextDrawingArea[] tda) {
		RSInterface tab = addTabInterface(23472);
		RSInterface scroll = addTabInterface(23473);
		addSprite(23474, 48, "Summon/SUMMON");
		addHoverButton(23475, "interfaces/summoning/creation/close", 9, 21, 21, "Close", 250, 23476, 3);
		addHoveredButton(23476, "interfaces/summoning/creation/close", 10, 21, 21, 23477);
		tab.totalChildren(4);
		tab.child(0, 23474, 16, 23);
		tab.child(1, 23475, 476, 33);
		tab.child(2, 23476, 476, 33);
		tab.child(3, 23473, 0, 63);
		int[] data = {// 12158 gold, 12159 green, 12160 crim, 16163 blue
				49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66,
				67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82,
				83, 84, 85 };
		int x = 67, y = 0, r = 0, s = 23478;
		scroll.height = 257;
		scroll.width = 477;
		scroll.scrollMax = 535;
		scroll.totalChildren(37);
		for (int i = 0; i < data.length; i++) {
			if (r == 4) {
				r = 0;
				y += 50;
				x = 67;
			}
			addButton(s, data[i], "Summon/SUMMON", "Infuse 5 Pouches");
			scroll.child(i, s, x, y);
			x += 110;
			s++;
			r++;
		}
	}
	
	

	private static Sprite loadSprite(int i, String s) {

		Sprite sprite;
		try {
			sprite = new Sprite(s + " " + i);
			if (sprite != null) {
				return sprite;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return sprite;
	}

	public Sprite loadSprite(String s, int i) {
		Sprite sprite;
		try {
			sprite = new Sprite(s + " " + i);
			if (sprite != null) {
				return sprite;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;

		}
		return null;
	}
	
	/*static int[] req = {1,2,3, 4};
	
	public static void pouchCreation(TextDrawingArea[] TDA) {
		int totalScrolls = pouchItems.length;
		int xPadding = 53;
		int yPadding = 57;
		int xPos = 13;
		int yPos = 20;
		RSInterface rsinterface = addTabInterface(23471);
		setChildren(7, rsinterface);
		addSprite(23472, 1, "interfaces/summoning/creation/summoning");
		addButton(23475, 0, "interfaces/summoning/creation/tab", "Transform Scolls");
		addSprite(23474, 1, "interfaces/summoning/creation/pouch");
		addSprite(23473, 1, "interfaces/summoning/creation/tab");
		addSprite(23476, 0, "interfaces/summoning/creation/scroll");
		addInAreaHover(23477, "interfaces/summoning/creation/close", 0, 1, 16, 16, "Close", 250, 3);
			//Scroll section
			RSInterface scroll = addTabInterface(23478);
			setChildren(3*totalScrolls, scroll);
			for(int i = 0; i < totalScrolls; i++) {
				addInAreaHover(23479 + (i*8), "interfaces/summoning/creation/box", 0, 1, 48, 52, "nothing", -1, 0);
				addPouch(23480 + (i*8), req, 1, pouchItems[i], summoningLevelRequirements[i], pouchNames[i], TDA, i,5);
				//addSprite(23485 + (i*8), pouchItems[i], null, 200, 200);
				setBounds(23479 + (i*8), 36+((i%8)*xPadding), 0+(i/8)*yPadding, 0+(i*2), scroll);
				setBounds(23480 + (i*8), 43+((i%8)*xPadding), 2+(i/8)*yPadding, 1+(i*2), scroll);
				//setBounds(23485 + (i*8), 43+((i%8)*xPadding), 2+(i/8)*yPadding, 1+(i*2), scroll);
			}
			for(int i = 0; i < totalScrolls; i++) {
				int drawX = 5+((i%8)*xPadding);
				if(drawX > 472-180)
					drawX -= 90;
				int drawY = 55+(i/8)*yPadding;
				if(drawY > 200-40)
					drawY -= 80;
				setBounds(23481 + (i*8), drawX, drawY, 2+((totalScrolls-1)*2)+i, scroll);
			}
			scroll.parentID = 23478;
			scroll.id = 23478;
			scroll.atActionType = 0;
			scroll.contentType = 0;
			scroll.width = 452 + 22;
			scroll.height = 257;
			scroll.scrollMax = 570;
			//
		setBounds(23472, xPos, yPos, 0, rsinterface);
		setBounds(23473, xPos + 9, yPos + 9, 1, rsinterface);
		setBounds(23474, xPos + 29, yPos + 10, 2, rsinterface);
		
		setBounds(23475, xPos + 79, yPos + 9, 3, rsinterface);
		setBounds(23476, xPos + 106, yPos + 10, 4, rsinterface);
		setBounds(23477, xPos + 461, yPos + 10, 5, rsinterface);
		setBounds(23478, 0, yPos + 39, 6, rsinterface);
	}
	
	
	public static void scrollCreation(TextDrawingArea[] TDA) {
		int totalScrolls = pouchItems.length;
		int xPadding = 53;
		int yPadding = 57;
		int xPos = 13;
		int yPos = 20;
		RSInterface rsinterface = addTabInterface(22760);
		setChildren(7, rsinterface);
		addSprite(22761, 0, "interfaces/summoning/creation/summoning");
		addButton(22762, 0, "interfaces/summoning/creation/tab", "Infuse Pouches");
		addSprite(22763, 0, "interfaces/summoning/creation/pouch");
		addSprite(22764, 1, "interfaces/summoning/creation/tab");
		addSprite(22765, 1, "interfaces/summoning/creation/scroll");
		addInAreaHover(22766, "interfaces/summoning/creation/close", 0, 1, 16, 16, "Close", 250, 3);
			//Scroll section
			RSInterface scroll = addTabInterface(22767);
			setChildren(4*totalScrolls, scroll);
			for(int i = 0; i < totalScrolls; i++) {
				addInAreaHover(22768 + (i*9), "interfaces/summoning/creation/box", 0, 1, 48, 52, "nothing", -1, 0);
				addScroll(22769 + (i*9), pouchItems[i], 1, scrollItems[i], summoningLevelRequirements[i], scrollNames[i], TDA, i,5);
				
				addSprite(22776 + (i*9), pouchItems[i], null, 50, 50);
				setBounds(22768 + (i*9), 36+((i%8)*xPadding), 0+(i/8)*yPadding, 0+(i*3), scroll);
				setBounds(22769 + (i*9), 43+((i%8)*xPadding), 2+(i/8)*yPadding, 1+(i*3), scroll);
				setBounds(22776 + (i*9), 28+((i%8)*xPadding), 28+(i/8)*yPadding, 2+(i*3), scroll);
			}
			for(int i = 0; i < totalScrolls; i++) {
				int drawX = 5+((i%8)*xPadding);
				if(drawX > 472-180)
					drawX -= 90;
				int drawY = 55+(i/8)*yPadding;
				if(drawY > 200-40)
					drawY -= 80;
				setBounds(22770 + (i*9), drawX, drawY, 3+((totalScrolls-1)*3)+i, scroll);
			}
			scroll.parentID = 22767;
			scroll.id = 22767;
			scroll.atActionType = 0;
			scroll.contentType = 0;
			scroll.width = 452 + 22;
			scroll.height = 257;
			scroll.scrollMax = 570;
			//
		setBounds(22761, xPos, yPos, 0, rsinterface);
		setBounds(22762, xPos + 9, yPos + 9, 1, rsinterface);
		setBounds(22763, xPos + 29, yPos + 10, 2, rsinterface);
		
		setBounds(22764, xPos + 79, yPos + 9, 3, rsinterface);
		setBounds(22765, xPos + 106, yPos + 10, 4, rsinterface);
		setBounds(22766, xPos + 461, yPos + 10, 5, rsinterface);
		setBounds(22767, 0, yPos + 39, 6, rsinterface);
	}

	public static void addSprite(int id, int spriteId, String spriteName, int zoom1, int zoom2) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.opacity = (byte)0;
		tab.hoverType = 52;
		if(spriteName == null) {
			tab.itemSpriteZoom1 = zoom1;
			tab.itemSpriteId1 = spriteId;
			tab.itemSpriteZoom2 = zoom2;
			tab.itemSpriteId2 = spriteId;
		} else {
			tab.sprite1 = imageLoader(spriteId, spriteName);
			tab.sprite2 = imageLoader(spriteId, spriteName);
		}
		tab.width = 512;
		tab.height = 334;
	}

	public static void addScroll(int ID, int r1, int ra1, int r2, int lvl, String name, TextDrawingArea[] TDA, int imageID, int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID + 1;
		rsInterface.width = 32;
		rsInterface.height = 32;
		rsInterface.tooltip = "Transform @or1@" + name;//infuse for pouches
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[2];
		rsInterface.requiredValues = new int[2];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = lvl-1;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[3];
		rsInterface.valueIndexArray[1][0] = 1;
		rsInterface.valueIndexArray[1][1] = 6;
		rsInterface.valueIndexArray[1][2] = 0;
		//rsInterface.sprite1 = null;
		rsInterface.itemSpriteId1 = r2;
		rsInterface.itemSpriteId2 = r2;
		rsInterface.itemSpriteZoom1 = 150;
		rsInterface.itemSpriteZoom2 = 150;
		rsInterface.itemSpriteIndex = imageID;
		rsInterface.greyScale = true;
		RSInterface hover = addTabInterface(ID + 1);//Hover interface ID
		hover.hoverType = -1;
		hover.interfaceShown = true;
		setChildren(5, hover);
		addSprite(ID + 2,0,"Lunar/BOX");
		addText(ID + 3, "Level " + (lvl) + ": " + name, 0xFF981F, true, true, 52, 1);
		addText(ID + 4, "This item requires", 0xAF6A1A, true, true, 52, 0);
		addRuneText(ID + 5, ra1, r1, TDA);
		addSprite(ID + 6, r1, null);
		
		setBounds(ID + 2, 0, 0, 0, hover);
		setBounds(ID + 3, 90, 4, 1, hover);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(ID + 5, 87, 66, 3, hover);
		setBounds(ID + 6, 72, 33, 4, hover);// Rune
	}
	
	public static void addPouch(int ID, int[] r1, int ra1, int r2, int lvl, String name, TextDrawingArea[] TDA, int imageID, int type) {
		RSInterface rsInterface = addTabInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.hoverType = ID + 1;
		rsInterface.width = 32;
		rsInterface.height = 32;
		rsInterface.tooltip = "Infuse @or1@" + name;//infuse for pouches
		rsInterface.spellName = name;
		rsInterface.valueCompareType = new int[2];
		rsInterface.requiredValues = new int[2];
		rsInterface.valueCompareType[0] = 3;
		rsInterface.requiredValues[0] = ra1;
		rsInterface.valueCompareType[1] = 3;
		rsInterface.requiredValues[1] = lvl-1;
		rsInterface.valueIndexArray = new int[2 + r1.length][];
		for(int i = 0; i < r1.length; i++) {
			rsInterface.valueIndexArray[i] = new int[4];
			rsInterface.valueIndexArray[i][0] = 4;
			rsInterface.valueIndexArray[i][1] = 3214;
			rsInterface.valueIndexArray[i][2] = r1[i];
			rsInterface.valueIndexArray[i][3] = 0;
		}
		rsInterface.valueIndexArray[1] = new int[3];
		rsInterface.valueIndexArray[1][0] = 1;
		rsInterface.valueIndexArray[1][1] = 6;
		rsInterface.valueIndexArray[1][2] = 0;
//		rsInterface.sprite1 = null;
		rsInterface.itemSpriteId1 = r2;
		rsInterface.itemSpriteId2 = r2;
		rsInterface.itemSpriteZoom1 = 150;
		rsInterface.itemSpriteZoom2 = 150;
		rsInterface.itemSpriteIndex = imageID;
		rsInterface.greyScale = true;
		RSInterface hover = addTabInterface(ID + 1);//Hover interface ID
		hover.hoverType = -1;
		hover.interfaceShown = true;
		setChildren(8, hover);
		addSprite(ID + 2,0,"Lunar/BOX");
		addText(ID + 3, "Level " + (lvl) + ": " + name, 0xFF981F, true, true, 52, 1);
		addText(ID + 4, "This item requires", 0xAF6A1A, true, true, 52, 0);
		addRuneText(ID + 5, ra1, r1[0], TDA);
		addSprite(ID + 6, r1[0], null);
		addSprite(ID + 7, r1[1], null);
		addSprite(ID + 8, r1[2], null);
		addSprite(ID + 9, r1[3], null);
		
		setBounds(ID + 2, 0, 0, 0, hover);
		setBounds(ID + 3, 90, 4, 1, hover);
		setBounds(ID + 4, 90, 19, 2, hover);
		setBounds(ID + 5, 87, 66, 3, hover);
		
		setBounds(ID + 6, 7, 33, 4, hover);// Rune
		setBounds(ID + 7, 50, 33, 5, hover);// Rune
		setBounds(ID + 8, 96, 33, 6, hover);// Rune
		setBounds(ID + 9, 144, 33, 7, hover);// Rune
	}*/

	
	public static void NewSkillTab(RSFont[] TDA) {
		RSInterface Interface = addInterface(31110);
			setChildren(104, Interface);

			addButtons(31111, 2, "Interfaces/SkillTab/SKILL", "View @or1@Attack @whi@guide", 31112, 1);
			drawTooltip(31112, "EXP: 14000000");
        		addText(31114, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31115, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31116, 22, "Interfaces/SkillTab/SKILL", "View @or1@Strength @whi@guide", 31117, 1);
			drawTooltip(31117, "EXP: 14000000");
        		addText(31119, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31120, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31121, 6, "Interfaces/SkillTab/SKILL", "View @or1@Defence @whi@guide", 31122, 1);
			drawTooltip(31122, "EXP: 14000000");
        		addText(31124, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31125, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31126, 18, "Interfaces/SkillTab/SKILL", "View @or1@Ranged @whi@guide", 31127, 1);
			drawTooltip(31127, "EXP: 14000000");
        		addText(31129, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31130, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31131, 17, "Interfaces/SkillTab/SKILL", "View @or1@Prayer @whi@guide", 31132, 1);
			drawTooltip(31132, "EXP: 14000000");
        		addText(31134, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31135, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31136, 15, "Interfaces/SkillTab/SKILL", "View @or1@Magic @whi@guide", 31137, 1);
			drawTooltip(31137, "EXP: 14000000");
        		addText(31139, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31140, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31141, 19, "Interfaces/SkillTab/SKILL", "View @or1@Runecrafting @whi@guide", 31142, 1);
			drawTooltip(31142, "EXP: 14000000");
        		addText(31144, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31145, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31146, 23, "Interfaces/SkillTab/SKILL", "View @or1@Summoning @whi@guide", 31147, 1);
			drawTooltip(31147, "EXP: 14000000");
        		addText(31149, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31150, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31151, 25, "Interfaces/SkillTab/SKILL", "", 31152, 1);
			drawTooltip(31152, "");
        		addText(31154, "", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31155, "", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        	


			addButtons(31156, 13, "Interfaces/SkillTab/SKILL", "View @or1@Hitpoints @whi@guide", 31157, 1);
			drawTooltip(31157, "EXP: 14000000");
        		addText(31159, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31160, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31161, 1, "Interfaces/SkillTab/SKILL", "View @or1@Agility @whi@guide", 31162, 1);
			drawTooltip(31162, "EXP: 14000000");
        		addText(31164, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31165, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31166, 12, "Interfaces/SkillTab/SKILL", "View @or1@Herblore @whi@guide", 31167, 1);
			drawTooltip(31167, "EXP: 14000000");
        		addText(31169, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31170, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31171, 24, "Interfaces/SkillTab/SKILL", "View @or1@Thieving @whi@guide", 31172, 1);
			drawTooltip(31172, "EXP: 14000000");
        		addText(31174, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31175, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31176, 5, "Interfaces/SkillTab/SKILL", "View @or1@Crafting @whi@guide", 31177, 1);
			drawTooltip(31177, "EXP: 14000000");
        		addText(31179, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31180, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31181, 11, "Interfaces/SkillTab/SKILL", "View @or1@Fletching @whi@guide", 31182, 1);
			drawTooltip(31182, "EXP: 14000000");
        		addText(31184, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31185, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31186, 20, "Interfaces/SkillTab/SKILL", "View @or1@Slayer @whi@guide", 31187, 1);
			drawTooltip(31187, "EXP: 14000000");
        		addText(31189, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31190, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31191, 14, "Interfaces/SkillTab/SKILL", "View @or1@Hunter @whi@guide", 31192, 1);
			drawTooltip(31192, "EXP: 14000000");
        		addText(31194, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31195, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31196, 0, "Interfaces/SkillTab/TOTAL", "View @or1@Total Level @whi@guide", 31197, 1);
			drawTooltip(31197, "Total EXP: 350000000");
        		addText(31199, "Total Level:", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31200, "2475", 0xFFEE33, false, true, 52, /*TDA,*/ 0);


			addButtons(31201, 16, "Interfaces/SkillTab/SKILL", "View @or1@Mining @whi@guide", 31202, 1);
			drawTooltip(31202, "EXP: 14000000");
        		addText(31204, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31205, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31206, 21, "Interfaces/SkillTab/SKILL", "View @or1@Smithing @whi@guide", 31207, 1);
			drawTooltip(31207, "EXP: 14000000");
        		addText(31209, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31210, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31211, 10, "Interfaces/SkillTab/SKILL", "View @or1@Fishing @whi@guide", 31212, 1);
			drawTooltip(31212, "EXP: 14000000");
        		addText(31214, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31215, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31216, 4, "Interfaces/SkillTab/SKILL", "View @or1@Cooking @whi@guide", 31217, 1);
			drawTooltip(31217, "EXP: 14000000");
        		addText(31219, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31220, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31221, 9, "Interfaces/SkillTab/SKILL", "View @or1@Firemaking @whi@guide", 31222, 1);
			drawTooltip(31222, "EXP: 14000000");
        		addText(31224, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31225, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31226, 0, "Interfaces/SkillTab/SKILL", "View @or1@Woodcutting @whi@guide", 31227, 1);
			drawTooltip(31227, "EXP: 14000000");
        		addText(31229, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31230, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31231, 8, "Interfaces/SkillTab/SKILL", "View @or1@Farming @whi@guide", 31232, 1);
			drawTooltip(31232, "EXP: 14000000");
        		addText(31234, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31235, "99", 0xFFEE33, false, true, 52, /*TDA,*/ 0);

			addButtons(31236, 25, "Interfaces/SkillTab/SKILL", "", 31237, 1);
			drawTooltip(31237, "");
        		addText(31239, "", 0xFFEE33, false, true, 52, /*TDA,*/ 0);
        		addText(31240, "", 0xFFEE33, false, true, 52, /*TDA,*/ 0);




			setBounds(31111, 3, 3, 100, Interface);//Button
			setBounds(31114, 31, 6, 101, Interface);//Fake lvl
			setBounds(31115, 43, 18, 102, Interface);//Real lvl
			setBounds(31112, 3, 31, 103, Interface);//Yellow box

			setBounds(31116, 3, 31, 96, Interface);//Button
			setBounds(31119, 31, 34, 97, Interface);//Fake lvl
			setBounds(31120, 43, 46, 98, Interface);//Real lvl
			setBounds(31117, 3, 59, 99, Interface);//Yellow box

			setBounds(31121, 3, 59, 92, Interface);//Button
			setBounds(31124, 31, 62, 93, Interface);//Fake lvl
			setBounds(31125, 43, 74, 94, Interface);//Real lvl
			setBounds(31122, 3, 87, 95, Interface);//Yellow box

			setBounds(31126, 3, 87, 88, Interface);//Button
			setBounds(31129, 31, 90, 89, Interface);//Fake lvl
			setBounds(31130, 43, 102, 90, Interface);//Real lvl
			setBounds(31127, 3, 115, 91, Interface);//Yellow box

			setBounds(31131, 3, 115, 84, Interface);//Button
			setBounds(31134, 31, 118, 85, Interface);//Fake lvl
			setBounds(31135, 43, 130, 86, Interface);//Real lvl
			setBounds(31132, 3, 143, 87, Interface);//Yellow box

			setBounds(31136, 3, 143, 80, Interface);//Button
			setBounds(31139, 31, 146, 81, Interface);//Fake lvl
			setBounds(31140, 43, 158, 82, Interface);//Real lvl
			setBounds(31137, 3, 171, 83, Interface);//Yellow box

			setBounds(31141, 3, 171, 76, Interface);//Button
			setBounds(31144, 31, 174, 77, Interface);//Fake lvl
			setBounds(31145, 43, 186, 78, Interface);//Real lvl
			setBounds(31142, 3, 199, 79, Interface);//Yellow box

			setBounds(31146, 3, 199, 72, Interface);//Button
			setBounds(31149, 31, 202, 73, Interface);//Fake lvl
			setBounds(31150, 43, 214, 74, Interface);//Real lvl
			setBounds(31147, 3, 227, 75, Interface);//Yellow box

			setBounds(31151, 3, 227, 68, Interface);//Button
			setBounds(31154, 31, 230, 69, Interface);//Fake lvl
			setBounds(31155, 43, 242, 70, Interface);//Real lvl
			setBounds(31152, 3, 255, 71, Interface);//Yellow box


			

			setBounds(31156, 64, 3, 64, Interface);//Button
			setBounds(31159, 92, 6, 65, Interface);//Fake lvl
			setBounds(31160, 104, 18, 66, Interface);//Real lvl
			setBounds(31157, 64, 31, 67, Interface);//Yellow box

			setBounds(31161, 64, 31, 60, Interface);//Button
			setBounds(31164, 92, 34, 61, Interface);//Fake lvl
			setBounds(31165, 104, 46, 62, Interface);//Real lvl
			setBounds(31162, 64, 59, 63, Interface);//Yellow box

			setBounds(31166, 64, 59, 56, Interface);//Button
			setBounds(31169, 92, 62, 57, Interface);//Fake lvl
			setBounds(31170, 104, 74, 58, Interface);//Real lvl
			setBounds(31167, 64, 87, 59, Interface);//Yellow box

			setBounds(31171, 64, 87, 52, Interface);//Button
			setBounds(31174, 92, 90, 53, Interface);//Fake lvl
			setBounds(31175, 104, 102, 54, Interface);//Real lvl
			setBounds(31172, 64, 115, 55, Interface);//Yellow box

			setBounds(31176, 64, 115, 48, Interface);//Button
			setBounds(31179, 92, 118, 49, Interface);//Fake lvl
			setBounds(31180, 104, 130, 50, Interface);//Real lvl
			setBounds(31177, 64, 143, 51, Interface);//Yellow box

			setBounds(31181, 64, 143, 44, Interface);//Button
			setBounds(31184, 92, 146, 45, Interface);//Fake lvl
			setBounds(31185, 104, 158, 46, Interface);//Real lvl
			setBounds(31182, 64, 171, 47, Interface);//Yellow box

			setBounds(31186, 64, 171, 40, Interface);//Button
			setBounds(31189, 92, 174, 41, Interface);//Fake lvl
			setBounds(31190, 104, 186, 42, Interface);//Real lvl
			setBounds(31187, 64, 199, 43, Interface);//Yellow box

			setBounds(31191, 64, 199, 36, Interface);//Button
			setBounds(31194, 92, 202, 37, Interface);//Fake lvl
			setBounds(31195, 104, 214, 38, Interface);//Real lvl
			setBounds(31192, 64, 227, 39, Interface);//Yellow box

			

			setBounds(31201, 125, 3, 32, Interface);//Button
			setBounds(31204, 153, 6, 33, Interface);//Fake lvl
			setBounds(31205, 165, 18, 34, Interface);//Real lvl
			setBounds(31202, 125, 31, 35, Interface);//Yellow box

			setBounds(31206, 125, 31, 28, Interface);//Button
			setBounds(31209, 153, 34, 29, Interface);//Fake lvl
			setBounds(31210, 165, 46, 30, Interface);//Real lvl
			setBounds(31207, 125, 59, 31, Interface);//Yellow box

			setBounds(31211, 125, 59, 24, Interface);//Button
			setBounds(31214, 153, 62, 25, Interface);//Fake lvl
			setBounds(31215, 165, 74, 26, Interface);//Real lvl
			setBounds(31212, 125, 87, 27, Interface);//Yellow box

			setBounds(31216, 125, 87, 20, Interface);//Button
			setBounds(31219, 153, 90, 21, Interface);//Fake lvl
			setBounds(31220, 165, 102, 22, Interface);//Real lvl
			setBounds(31217, 125, 115, 23, Interface);//Yellow box

			setBounds(31221, 125, 115, 16, Interface);//Button
			setBounds(31224, 153, 118, 17, Interface);//Fake lvl
			setBounds(31225, 165, 130, 18, Interface);//Real lvl
			setBounds(31222, 125, 143, 19, Interface);//Yellow box

			setBounds(31226, 125, 143, 12, Interface);//Button
			setBounds(31229, 153, 146, 13, Interface);//Fake lvl
			setBounds(31230, 165, 158, 14, Interface);//Real lvl
			setBounds(31227, 125, 171, 15, Interface);//Yellow box

			setBounds(31231, 125, 171, 8, Interface);//Button
			setBounds(31234, 153, 174, 9, Interface);//Fake lvl
			setBounds(31235, 165, 186, 10, Interface);//Real lvl
			setBounds(31232, 125, 199, 11, Interface);//Yellow box

			setBounds(31236, 125, 199, 4, Interface);//Button
			setBounds(31239, 153, 202, 5, Interface);//Fake lvl
			setBounds(31240, 165, 214, 6, Interface);//Real lvl
			setBounds(31237, 125, 227, 7, Interface);//Yellow box

			setBounds(31196, 64, 227, 0, Interface);//Total level
			setBounds(31199, 105, 229, 1, Interface);//Text
			setBounds(31200, 116, 241, 2, Interface);//Lvl
			setBounds(31197, 64, 255, 3, Interface);//Yellow box




	}
	
	 public static void addText(int i, String s, int k, boolean l, boolean m, int a, int j)
	    {
	        RSInterface rsinterface = addTabInterface(i);
	        rsinterface.parentID = i;
	        rsinterface.id = i;
	        rsinterface.type = 4;
	        rsinterface.atActionType = 0;
	        rsinterface.width = 0;
	        rsinterface.height = 0;
	        rsinterface.contentType = 0;
	        rsinterface.mOverInterToTrigger = a;
	        rsinterface.centerText = l;
	        rsinterface.textShadow = m;
	        rsinterface.textDrawingAreas = fonts[j];
	        rsinterface.message = s;
	        rsinterface.textColor = k;
	    }
	
	public static void addInAreaHover(int i, String imageName, int sId, int sId2, int w, int h, String text, int contentType, 
            int actionType)
    {
        RSInterface tab = addTabInterface(i);
        tab.id = i;
        tab.parentID = i;
        tab.type = 5;
        tab.atActionType = actionType;
        tab.contentType = contentType;
        tab.opacity = 0;
        tab.mOverInterToTrigger = i;
        if(sId != -1)
        tab.sprite1 = imageLoader(sId, imageName);
        tab.sprite2 = imageLoader(sId2, imageName);
        tab.width = w;
        tab.height = h;
        tab.tooltip = text;
    }
	
	public static void addSprite(int id, int spriteId, String spriteName, int zoom1, int zoom2) // summon pouch creation
    {
        RSInterface tab = interfaceCache[id] = new RSInterface();
        tab.id = id;
        tab.parentID = id;
        tab.type = 5;
        tab.atActionType = 0;
        tab.contentType = 0;
        tab.opacity = 0;
        tab.mOverInterToTrigger = 52;
        if(spriteName == null)
        {
            tab.itemSpriteZoom1 = zoom1;
            tab.itemSpriteId1 = spriteId;
            tab.itemSpriteZoom2 = zoom2;
            tab.itemSpriteId2 = spriteId;
        } else
        {
            tab.sprite1 = imageLoader(spriteId, spriteName);
            tab.sprite2 = imageLoader(spriteId, spriteName);
        }
        tab.width = 512;
        tab.height = 334;
    }
	
	public static void pouchCreation(TextDrawingArea TDA[])
    {
        int totalScrolls = pouchItems.length;
        int xPadding = 53;
        int yPadding = 57;
        int xPos = 13;
        int yPos = 20;
        RSInterface rsinterface = addTabInterface(23471);
        setChildren(7, rsinterface);
        addSprite(23472, 1, "interfaces/summoning/creation/summoning");
        addButton(23475, 0, "interfaces/summoning/creation/tab", "Transform Scolls");
        addSprite(23474, 1, "interfaces/summoning/creation/pouch");
        addSprite(23473, 1, "interfaces/summoning/creation/tab");
        addSprite(23476, 0, "interfaces/summoning/creation/scroll");
        addInAreaHover(23477, "interfaces/summoning/creation/close", 0, 1, 16, 16, "Close", 250, 3);
        RSInterface scroll = addTabInterface(23478);
        setChildren(3 * totalScrolls, scroll);
        for(int i = 0; i < totalScrolls; i++)
        {
            addInAreaHover(23479 + i * 8, "interfaces/summoning/creation/box", 0, 1, 48, 52, "nothing", -1, 0);
            int req[] = {
                1, 2, 3
            };
            addPouch(23480 + i * 8, req, 1, pouchItems[i], summoningLevelRequirements[i], pouchNames[i], TDA, i, 5);
            addSprite(23485 + i * 8, pouchItems[i], null, 50, 50);
            setBounds(23479 + i * 8, 36 + (i % 8) * xPadding, 0 + (i / 8) * yPadding, 0 + i * 2, scroll);
            setBounds(23480 + i * 8, 43 + (i % 8) * xPadding, 2 + (i / 8) * yPadding, 1 + i * 2, scroll);
        }

        for(int i = 0; i < totalScrolls; i++)
        {
            int drawX = 5 + (i % 8) * xPadding;
            if(drawX > 292)
                drawX -= 90;
            int drawY = 55 + (i / 8) * yPadding;
            if(drawY > 160)
                drawY -= 80;
            setBounds(23481 + i * 8, drawX, drawY, 2 + (totalScrolls - 1) * 2 + i, scroll);
        }

        scroll.parentID = 23478;
        scroll.id = 23478;
        scroll.atActionType = 0;
        scroll.contentType = 0;
        scroll.width = 474;
        scroll.height = 257;
        scroll.scrollMax = 570;
        setBounds(23472, xPos, yPos, 0, rsinterface);
        setBounds(23473, xPos + 9, yPos + 9, 1, rsinterface);
        setBounds(23474, xPos + 29, yPos + 10, 2, rsinterface);
        setBounds(23475, xPos + 79, yPos + 9, 3, rsinterface);
        setBounds(23476, xPos + 106, yPos + 10, 4, rsinterface);
        setBounds(23477, xPos + 461, yPos + 10, 5, rsinterface);
        setBounds(23478, 0, yPos + 39, 6, rsinterface);
    }

    public static void scrollCreation(TextDrawingArea TDA[])
    {
        int totalScrolls = pouchItems.length;
        int xPadding = 53;
        int yPadding = 57;
        int xPos = 13;
        int yPos = 20;
        RSInterface rsinterface = addTabInterface(22760);
        setChildren(7, rsinterface);
        addSprite(22761, 0, "Interfaces/summoning/creation/summoning");
        addButton(22762, 0, "Interfaces/summoning/creation/tab", "Infuse Pouches");
        addSprite(22763, 0, "Interfaces/summoning/creation/pouch");
        addSprite(22764, 1, "Interfaces/summoning/creation/tab");
        addSprite(22765, 1, "Interfaces/summoning/creation/scroll");
        addInAreaHover(22766, "Interfaces/summoning/creation/close", 0, 1, 16, 16, "Close", 250, 3);
        RSInterface scroll = addTabInterface(22767);
        setChildren(4 * totalScrolls, scroll);
        for(int i = 0; i < totalScrolls; i++)
        {
            addInAreaHover(22768 + i * 9, "Interfaces/summoning/creation/box", 0, 1, 48, 52, "nothing", -1, 0);
            addScroll(22769 + i * 9, pouchItems[i], 1, scrollItems[i], summoningLevelRequirements[i], scrollNames[i], TDA, i, 5);
            addSprite(22776 + i * 9, pouchItems[i], "", 50, 50);
            setBounds(22768 + i * 9, 36 + (i % 8) * xPadding, 0 + (i / 8) * yPadding, 0 + i * 3, scroll);
            setBounds(22769 + i * 9, 43 + (i % 8) * xPadding, 2 + (i / 8) * yPadding, 1 + i * 3, scroll);
            setBounds(22776 + i * 9, 28 + (i % 8) * xPadding, 28 + (i / 8) * yPadding, 2 + i * 3, scroll);
        }

        for(int i = 0; i < totalScrolls; i++)
        {
            int drawX = 5 + (i % 8) * xPadding;
            if(drawX > 292)
                drawX -= 90;
            int drawY = 55 + (i / 8) * yPadding;
            if(drawY > 160)
                drawY -= 80;
            setBounds(22770 + i * 9, drawX, drawY, 3 + (totalScrolls - 1) * 3 + i, scroll);
        }

        scroll.parentID = 22767;
        scroll.id = 22767;
        scroll.atActionType = 0;
        scroll.contentType = 0;
        scroll.width = 474;
        scroll.height = 257;
        scroll.scrollMax = 570;
        setBounds(22761, xPos, yPos, 0, rsinterface);
        setBounds(22762, xPos + 9, yPos + 9, 1, rsinterface);
        setBounds(22763, xPos + 29, yPos + 10, 2, rsinterface);
        setBounds(22764, xPos + 79, yPos + 9, 3, rsinterface);
        setBounds(22765, xPos + 106, yPos + 10, 4, rsinterface);
        setBounds(22766, xPos + 461, yPos + 10, 5, rsinterface);
        setBounds(22767, 0, yPos + 39, 6, rsinterface);
    }
    
    public static void addScroll(int ID, int r1, int ra1, int r2, int lvl, String name, TextDrawingArea TDA[], int imageID, 
            int type)
    {
        RSInterface rsInterface = addTabInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID + 1;
        rsInterface.width = 32;
        rsInterface.height = 32;
        rsInterface.tooltip = (new StringBuilder()).append("Transform @or1@").append(name).toString();
        rsInterface.spellName = name;
        rsInterface.valueCompareType = new int[2];
        rsInterface.requiredValues = new int[2];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = lvl - 1;
        rsInterface.valueIndexArray = new int[3][];
        rsInterface.valueIndexArray[0] = new int[4];
        rsInterface.valueIndexArray[0][0] = 4;
        rsInterface.valueIndexArray[0][1] = 3214;
        rsInterface.valueIndexArray[0][2] = r1;
        rsInterface.valueIndexArray[0][3] = 0;
        rsInterface.valueIndexArray[1] = new int[3];
        rsInterface.valueIndexArray[1][0] = 1;
        rsInterface.valueIndexArray[1][1] = 6;
        rsInterface.valueIndexArray[1][2] = 0;
        rsInterface.itemSpriteId1 = r2;
        rsInterface.itemSpriteId2 = r2;
        rsInterface.itemSpriteIndex = imageID;
        rsInterface.greyScale = true;
        RSInterface hover = addTabInterface(ID + 1);
        hover.mOverInterToTrigger = -1;
        hover.isMouseoverTriggered = true;
        setChildren(5, hover);
        addSprite(ID + 2, 0, "Lunar/BOX");
        addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl).append(": ").append(name).toString(), 0xff981f, true, true, 52, 1);
        addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
        addRuneText(ID + 5, ra1, r1, TDA);
        addSprite(ID + 6, r1, "");
        setBounds(ID + 2, 0, 0, 0, hover);
        setBounds(ID + 3, 90, 4, 1, hover);
        setBounds(ID + 4, 90, 19, 2, hover);
        setBounds(ID + 5, 87, 66, 3, hover);
        setBounds(ID + 6, 72, 33, 4, hover);
    }

    public static void addPouch(int ID, int r1[], int ra1, int r2, int lvl, String name, TextDrawingArea TDA[], int imageID, 
            int type)
    {
        RSInterface rsInterface = addTabInterface(ID);
        rsInterface.id = ID;
        rsInterface.parentID = 1151;
        rsInterface.type = 5;
        rsInterface.atActionType = type;
        rsInterface.contentType = 0;
        rsInterface.mOverInterToTrigger = ID + 1;
        rsInterface.width = 32;
        rsInterface.height = 32;
        rsInterface.tooltip = (new StringBuilder()).append("Infuse @or1@").append(name).toString();
        rsInterface.spellName = name;
        rsInterface.valueCompareType = new int[2];
        rsInterface.requiredValues = new int[2];
        rsInterface.valueCompareType[0] = 3;
        rsInterface.requiredValues[0] = ra1;
        rsInterface.valueCompareType[1] = 3;
        rsInterface.requiredValues[1] = lvl - 1;
        rsInterface.valueIndexArray = new int[2 + r1.length][];
        for(int i = 0; i < r1.length; i++)
        {
            rsInterface.valueIndexArray[i] = new int[4];
            rsInterface.valueIndexArray[i][0] = 4;
            rsInterface.valueIndexArray[i][1] = 3214;
            rsInterface.valueIndexArray[i][2] = r1[i];
            rsInterface.valueIndexArray[i][3] = 0;
        }

        rsInterface.valueIndexArray[1] = new int[3];
        rsInterface.valueIndexArray[1][0] = 1;
        rsInterface.valueIndexArray[1][1] = 6;
        rsInterface.valueIndexArray[1][2] = 0;
        rsInterface.itemSpriteId1 = r2;
        rsInterface.itemSpriteId2 = r2;
        rsInterface.itemSpriteIndex = imageID;
        rsInterface.greyScale = true;
        RSInterface hover = addTabInterface(ID + 1);
        hover.mOverInterToTrigger = -1;
        hover.isMouseoverTriggered = true;
        setChildren(5, hover);
        addSprite(ID + 2, 0, "Lunar/BOX");
        addText(ID + 3, (new StringBuilder()).append("Level ").append(lvl).append(": ").append(name).toString(), 0xff981f, true, true, 52, 1);
        addText(ID + 4, "This item requires", 0xaf6a1a, true, true, 52, 0);
        addRuneText(ID + 5, ra1, r1[0], TDA);
        addSprite(ID + 6, r1[0], "");
        addSprite(ID + 7, r1[1], "");
        addSprite(ID + 8, r1[2], "");
        setBounds(ID + 2, 0, 0, 0, hover);
        setBounds(ID + 3, 90, 4, 1, hover);
        setBounds(ID + 4, 90, 19, 2, hover);
        setBounds(ID + 5, 87, 66, 3, hover);
        setBounds(ID + 6, 14, 33, 4, hover);
    }
   
	/*
	* +602's Skill interface.
	*/
	
	public static TextDrawingArea[] fonts;


	/*
	* +602's Skill interface.
	*/
	
	//public static TextDrawingArea[] fonts;

/*
public static void skillTab602(TextDrawingArea[] TDA) {
		RSInterface skill = addInterface(3917);
		addText(27203, "99", 0xFFFF00, false, true, -1, TDA, 0);
		addText(27204, "99", 0xFFFF00, false, true, -1, TDA, 0);
		addText(27205, "99", 0xFFFF00, false, true, -1, TDA, 0);
		addText(27206, "99", 0xFFFF00, false, true, -1, TDA, 0);
		skill.totalChildren(4);
		skill.child(0, 27203, 158, 175);
		skill.child(1, 27204, 171, 186);
		skill.child(2, 27205, 158, 203);
		skill.child(3, 27206, 171, 214);
		String[] spriteNames = { "Attack", "HP", "Mine", "Strength", "Agility", "Smith", "Defence", "Herblore", "Fish", "Range", "Thief", "Cook", "Prayer", "Craft", "Fire", "Mage", "Fletch", "Wood", "Rune", "Slay", "Farm", "Construction", "Hunter" };
		int[] buttons = { 8654, 8655, 8656, 8657, 8658, 8659, 8660, 8861, 8662, 8663, 8664, 8665, 8666, 8667, 8668, 8669, 8670, 8671, 8672, 12162, 13928, 27125, 27124 };
		int[] hovers = { 4040, 4076, 4112, 4046, 4082, 4118, 4052, 4088, 4124, 4058, 4094, 4130, 4064, 4100, 4136, 4070, 4106, 4142, 4160, 2832, 13917, 19007, 19006 };
		int[][] text = { { 4004, 4005 }, { 4016, 4017 }, { 4028, 4029 },
				{ 4006, 4007 }, { 4018, 4019 }, { 4030, 4031 }, { 4008, 4009 },
				{ 4020, 4021 }, { 4032, 4033 }, { 4010, 4011 }, { 4022, 4023 },
				{ 4034, 4035 }, { 4012, 4013 }, { 4024, 4025 }, { 4036, 4037 },
				{ 4014, 4015 }, { 4026, 4027 }, { 4038, 4039 }, { 4152, 4153 },
				{ 12166, 12167 }, { 13926, 13927 }, { 18165, 18169 },
				{ 18166, 18170 }, { 18167, 18171 }, { 18168, 18172 } };

		int[] icons = { 3965, 3966, 3967, 3968, 3969, 3970, 3971, 3972, 3973,
				3974, 3975, 3976, 3977, 3978, 3979, 3980, 3981, 3982, 4151,
				12165, 13925, 27129, 27128 };

		int[][] buttonCoords = { { 4, 4 }, { 66, 4 }, { 128, 4 }, { 4, 32 },
				{ 66, 32 }, { 128, 32 }, { 4, 60 }, { 66, 60 }, { 128, 60 },
				{ 4, 88 }, { 66, 88 }, { 128, 88 }, { 4, 116 }, { 66, 116 },
				{ 128, 116 }, { 4, 144 }, { 66, 144 }, { 128, 144 },
				{ 4, 172 }, { 66, 172 }, { 128, 172 }, { 4, 200 }, { 66, 200 },
				{ 128, 200 }, { 4, 229 } };
		int[][] iconCoords = { { 6, 6 }, { 69, 7 }, { 131, 6 }, { 9, 34 },
				{ 68, 33 }, { 131, 36 }, { 9, 64 }, { 67, 63 }, { 131, 61 },
				{ 7, 91 }, { 68, 94 }, { 133, 90 }, { 6, 118 }, { 70, 120 },
				{ 130, 118 }, { 6, 147 }, { 69, 146 }, { 132, 146 },
				{ 6, 173 }, { 69, 173 }, { 130, 174 }, { 6, 202 }, { 69, 201 },
				{ 131, 202 }, { 6, 230 } };
		int[][] textCoords = { { 31, 7, 44, 18 }, { 93, 7, 106, 18 },
				{ 155, 7, 168, 18 }, { 31, 35, 44, 46 }, { 93, 35, 106, 46 },
				{ 155, 35, 168, 46 }, { 31, 63, 44, 74 }, { 93, 63, 106, 74 },
				{ 155, 63, 168, 74 }, { 31, 91, 44, 102 },
				{ 93, 91, 106, 102 }, { 155, 91, 168, 102 },
				{ 31, 119, 44, 130 }, { 93, 119, 106, 130 },
				{ 155, 119, 168, 130 }, { 31, 149, 44, 158 },
				{ 93, 147, 106, 158 }, { 155, 147, 168, 158 },
				{ 31, 175, 44, 186 }, { 93, 175, 106, 186 },
				{ 155, 175, 168, 186 }, { 31, 203, 44, 214 },
				{ 93, 203, 106, 214 }, { 155, 203, 168, 214 },
				{ 31, 231, 44, 242 } };
		int[][] newText = { { 18165, 18166, 18167, 18168 },
				{ 18169, 18170, 18171, 18172 } };
				//27123, 27124, 27125, 27126
		for (int i = 0; i < hovers.length; i++) {
			createSkillHover(hovers[i], 205 + i);
			addSkillButton(buttons[i]);
			addImage(icons[i], spriteNames[i]);
		}
		for (int i = 0; i < 4; i++) {
			addSkillText(newText[0][i], false, i + 21);
			addSkillText(newText[1][i], true, i + 21);
		}
		skill.children(icons.length + (text.length * 2) + hovers.length + buttons.length + 1);
		int frame = 0;
		RSInterface totalLevel = interfaceCache[3984];
		totalLevel.message = "@yel@Total level: %1";
		totalLevel.textDrawingAreas = fonts[2];
		skill.child(frame, 3984, 74, 237); frame++;
		for (int i = 0; i < buttons.length; i++) {
			skill.child(frame, buttons[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
		for (int i = 0; i < icons.length; i++) {
			skill.child(frame, icons[i], iconCoords[i][0], iconCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][0], textCoords[i][0], textCoords[i][1]); frame++;
		}
		for (int i = 0; i < text.length; i++) {
			skill.child(frame, text[i][1], textCoords[i][2], textCoords[i][3]); frame++;
		}
		for (int i = 0; i < hovers.length; i++) {
			skill.child(frame, hovers[i], buttonCoords[i][0], buttonCoords[i][1]); frame++;
		}
	}
*/
	public void children(int total) {
		children = new int[total];
		childX = new int[total];
		childY = new int[total];
	}


	public static void createSkillHover(int id, int x) {
		RSInterface hover = addInterface(id);
		hover.type = 8;
		hover.message = "";
		hover.contentType = x;
		hover.width = 60;
		hover.height = 28;
		hover.inventoryHover = true;
	}
	public static void addImage(int id, String s) {
		RSInterface image = addInterface(id);
		image.type = 5;
		image.atActionType = 0;
		image.contentType = 0;
		image.width = 100;
		image.height = 100;
		image.sprite1 = getSprite(s);
	}
	
	public static void addSkillText(int id, boolean max, int skill) {
		RSInterface text = addInterface(id);
		text.id = id;
		text.parentID = id;
		text.type = 4;
		text.atActionType = 0;
		text.width = 15;
		text.height = 12;
		text.textDrawingAreas = fonts[0];
		text.textShadow = true;
		text.centerText = true;
		text.textColor = 16776960;
		if (!max) {
			text.valueIndexArray = new int[1][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
		} else {
			text.valueIndexArray = new int[2][];
			text.valueIndexArray[0] = new int[3];
			text.valueIndexArray[0][0] = 1;
			text.valueIndexArray[0][1] = skill;
			text.valueIndexArray[0][2] = 0;
			text.valueIndexArray[1] = new int[1];
			text.valueIndexArray[1][0] = 0;
		}
		text.message = "%1";
	}
public static Sprite getSprite(String s) {
		Sprite image;
		try {
			image = new Sprite(s);
			if (image != null) {
				return image;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return image;
	}
	public static void addSkillButton(int id) {
		RSInterface button = addInterface(id);
		button.type = 5;
		button.atActionType = 5;
		button.contentType = 0;
		button.width = 60;
		button.height = 27;
		button.sprite1 = CustomSpriteLoader(33225, "");
		button.sprite1 = getSprite("Button");
		button.tooltip = "View";
	}
	
	
	private static final int WHITE_TEXT = 0xFFFFFF;
	private static final int GREY_TEXT = 0xB9B855;
	private static final int ORANGE_TEXT = 0xFF981F;
	
	private static void summoningTab(TextDrawingArea[] tda) {
		final String dir = "Interfaces/Summoning/Tab/SPRITE";
		RSInterface rsi = addTabInterface(19017);
		addButton(19018, 0, dir, 143, 13, "Cast special", 1); 
		addText(19019, "S P E C I A L  M O V E", tda, 0, WHITE_TEXT, false, false);
		addSprite(19020, 1, dir);
		addFamiliarHead(19021, 75, 50, 875);
		addSprite(19022, 2, dir);
		addConfigButton(19023, 19017, 4, 3, dir, 30, 31, "Cast special", 0, 1, 330);
		addText(19024, "0", tda, 0, ORANGE_TEXT, false, true);
		addSprite(19025, 5, dir);
		addConfigButton(19026, 19017, 7, 6, dir, 29, 39, "Attack", 0, 1, 333);
		addSprite(19027, 8, dir);
		addText(19028, "None", tda, 2, ORANGE_TEXT, true, false);
		addHoverButton(19029, dir, 9, 38, 38, "Withdraw BoB", -1, 19030, 1);
		addHoveredButton(19030, dir, 10, 38, 38, 19031);
		addHoverButton(19032, dir, 11, 38, 38, "Renew familiar", -1, 19033, 1);
		addHoveredButton(19033, dir, 12, 38, 38, 19034);
		addHoverButton(19035, dir, 13, 38, 38, "Call follower", -1, 19036, 1);
		addHoveredButton(19036, dir, 14, 38, 38, 19037);
		addHoverButton(19038, dir, 15, 38, 38, "Dismiss familiar", -1, 19039, 1);
		addHoveredButton(19039, dir, 16, 38, 38, 19040);
		addSprite(19041, 17, dir);
		addSprite(19042, 18, dir);
		addText(19043, "35.30", tda, 0, GREY_TEXT, false, true);
		addSprite(19044, 19, dir);
		addText(19045, "63/69", tda, 0, GREY_TEXT, false, true);
		setChildren(24, rsi);
		setBounds(19018, 23, 10, 0, rsi);
		setBounds(19019, 43, 12, 1, rsi);
		setBounds(19020, 10, 32, 2, rsi);
		setBounds(19021, 63, 60, 3, rsi);
		setBounds(19022, 11, 32, 4, rsi);
		setBounds(19023, 14, 35, 5, rsi);
		setBounds(19024, 25, 69, 6, rsi);
		setBounds(19025, 138, 32, 7, rsi);
		setBounds(19026, 143, 36, 8, rsi);
		setBounds(19027, 12, 144, 9, rsi);
		setBounds(19028, 93, 146, 10, rsi);
		setBounds(19029, 23, 168, 11, rsi);
		setBounds(19030, 23, 168, 12, rsi);
		setBounds(19032, 75, 168, 13, rsi);
		setBounds(19033, 75, 168, 14, rsi);
		setBounds(19035, 23, 213, 15, rsi);
		setBounds(19036, 23, 213, 16, rsi);
		setBounds(19038, 75, 213, 17, rsi);
		setBounds(19039, 75, 213, 18, rsi);
		setBounds(19041, 130, 168, 19, rsi);
		setBounds(19042, 153, 170, 20, rsi);
		setBounds(19043, 148, 198, 21, rsi);
		setBounds(19044, 149, 213, 22, rsi);
		setBounds(19045, 145, 241, 23, rsi);
	}
	
	/*private static void petSummoningTab(TextDrawingArea[] tda) {
		final String dir = "Interfaces/Summoning/Tab/SPRITE";
		RSInterface rsi = addTabInterface(19017);
		addSprite(19018, 1, dir);
		addFamiliarHead(19019, 75, 50, 900);
		addSprite(19020, 8, dir);
		addText(19021, "None", tda, 2, ORANGE_TEXT, true, false);
		addHoverButton(19022, dir, 13, 38, 38, "Call follower", -1, 19023, 1);
		addHoveredButton(19023, dir, 14, 38, 38, 19024);
		addHoverButton(19025, dir, 15, 38, 38, "Dismiss familiar", -1, 19026, 1);
		addHoveredButton(19026, dir, 16, 38, 38, 19027);
		addSprite(19028, 17, dir);
		addSprite(19029, 20, dir);
		addText(19030, "0%", tda, 0, GREY_TEXT, false, true);
		addSprite(19031, 21, dir);
		addText(19032, "0%", tda, 0, WHITE_TEXT, false, true);
		setChildren(13, rsi);
		setBounds(19018, 10, 32, 0, rsi);
		setBounds(19019, 65, 65, 1, rsi);
		setBounds(19020, 12, 145, 2, rsi);
		setBounds(19021, 93, 147, 3, rsi);
		setBounds(19022, 23, 213, 4, rsi);
		setBounds(19023, 23, 213, 5, rsi);
		setBounds(19025, 75, 213, 6, rsi);
		setBounds(19026, 75, 213, 7, rsi);
		setBounds(19028, 130, 168, 8, rsi);
		setBounds(19029, 148, 170, 9, rsi);
		setBounds(19030, 152, 198, 10, rsi);
		setBounds(19031, 149, 220, 11, rsi);
		setBounds(19032, 155, 241, 12, rsi);
	}*/
	
	private static void addFamiliarHead(int interfaceID, int width, int height, int zoom) {
       	 	RSInterface rsi = addTabInterface(interfaceID);
        	rsi.type = 6;
			rsi.anInt233 = 2;
			rsi.mediaID = 4000;
        	rsi.modelZoom = zoom;
        	rsi.modelRotation1 = 40;
        	rsi.modelRotation2 = 1800;
        	rsi.height = height;
        	rsi.width = width;
    	}

	/*public static void bank(TextDrawingArea[] TDA) {
		RSInterface Tab = addTabInterface(23000);
		addText(23003, "", TDA, 0, 0xFFB000, false, false);
		addHover(23004, 3, 0, 23005, 1, "Bank/BANK", 16, 16, "Close");
		addHovered(23005, 2, "Bank/BANK", 16, 16, 23006);
		addHover(23007, 4, 0, 23008, 17, "Bank/BANK", 35, 25,
				"Deposit carried items");
		addHovered(23008, 18, "Bank/BANK", 35, 25, 23009);
		Tab.children = new int[7];
		Tab.childX = new int[7];
		Tab.childY = new int[7];
		Tab.children[0] = 5292;
		Tab.childX[0] = 0;
		Tab.childY[0] = 0;
		Tab.children[1] = 23003;
		Tab.childX[1] = 410;
		Tab.childY[1] = 30;
		Tab.children[2] = 23004;
		Tab.childX[2] = 472;
		Tab.childY[2] = 29;
		Tab.children[3] = 23005;
		Tab.childX[3] = 472;
		Tab.childY[3] = 29;
		Tab.children[4] = 23007;
		Tab.childX[4] = 450;
		Tab.childY[4] = 288;
		Tab.children[5] = 23008;
		Tab.childX[5] = 450;
		Tab.childY[5] = 288;
		Tab.children[6] = 23008;
		Tab.childX[6] = 3000;
		Tab.childY[6] = 5000;
		RSInterface rsi = interfaceCache[5292];
		addText(5384, "", TDA, 0, 0xFFB000, false, false);// cheap hax
		rsi.childX[90] = 410;
		rsi.childY[90] = 288;
	}*/

	public static void drawTooltip(int id, String text) {
		RSInterface rsinterface = addTabInterface(id);
		rsinterface.parentID = id;
		rsinterface.type = 0;
		rsinterface.isMouseoverTriggered = true;
		rsinterface.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsinterface.totalChildren(1);
		rsinterface.child(0, id + 1, 0, 0);
	}

	public static void addButton(int i, int j, String name, int W, int H,
			String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = AT;
		RSInterface.contentType = 0;
		RSInterface.opacity = 0;
		RSInterface.hoverType = 52;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.sprite2 = imageLoader(j, name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	public boolean newScroller;

	public static void questTab(TextDrawingArea[] TDA) {
		RSInterface Interface = addInterface(638);
		setChildren(4, Interface);
		addText(29155, "@", 0xFF981F, false, true, 52, TDA, 2);
		addButton(29156, 1, "Interfaces/QuestTab/QUEST", 18, 18,
				"Swap to Achievements", 1);
		addSprite(29157, 0, "Interfaces/QuestTab/QUEST");
		setBounds(29155, 10, 5, 0, Interface);
		setBounds(29156, 165, 5, 1, Interface);
		setBounds(29157, 3, 24, 2, Interface);
		setBounds(29160, 5, 29, 3, Interface);
		Interface = addInterface(29160);
		Interface.height = 214;
		Interface.width = 165;
		Interface.scrollMax = 1700;
		Interface.newScroller = false;
		setChildren(105, Interface);
		addText(29161, "Player", 0xFF981F, false, true, 52, TDA, 2);
		addHoverText(29162, "", "View Progress", TDA, 0,
				0xff0000, false, true, 150);
		addHoverText(29163, "", "View Progress", TDA, 0,
				0xff0000, false, true, 150);
		addHoverText(29164, "", "View Progress", TDA, 0,
				0xff0000, false, true, 150);
		addHoverText(29165, "", "View Progress", TDA, 0,
				0xff0000, false, true, 150);
		addHoverText(29166, "", "View Progress", TDA, 0, 0xff0000,
				false, true, 150);
		setBounds(29161, 4, 4, 0, Interface);
		setBounds(29162, 8, 22, 1, Interface);
		setBounds(29163, 8, 35, 2, Interface);
		setBounds(29164, 8, 48, 3, Interface);
		setBounds(29165, 8, 61, 4, Interface);
		setBounds(29166, 8, 74, 5, Interface);
		setBounds(663, 4, 90, 6, Interface);
		int Ypos = 108;
		int frameID = 7;
		for (int iD = 29167; iD <= 29264; iD++) {
			addHoverText(iD, "", "View"/* "View Quest Journal, "+iD */, TDA,
					0, 0xff0000, false, true, 150);
			setBounds(iD, 8, Ypos, frameID, Interface);
			frameID++;
			Ypos += 13;
			Ypos++;
		}
		Interface = addInterface(29265);
		try {
			setChildren(4, Interface);
			addText(29266, "        Achievements", 0xFF981F, false, true, -1,
					TDA, 2);
			addButton(29267, 2, "Interfaces/QuestTab/QUEST", 18, 18,
					"Swap to Quests", 1);
			addSprite(29269, 0, "Interfaces/QuestTab/QUEST");
			setBounds(29266, 10, 5, 0, Interface);
			setBounds(29267, 165, 5, 1, Interface);
			setBounds(29269, 3, 24, 2, Interface);
			setBounds(29268, 5, 29, 3, Interface);
			Interface = addInterface(29268);
			Interface.height = 214;
			Interface.width = 165;
			Interface.scrollMax = 1700;
			Interface.newScroller = false;
			setChildren(11, Interface);
			setBounds(29295, 8, 6, 0, Interface);
			setBounds(29287, 8, 21, 1, Interface);
			setBounds(29305, 8, 36, 2, Interface);
			setBounds(29306, 8, 51, 3, Interface);
			setBounds(29307, 8, 66, 4, Interface);
			setBounds(29308, 8, 81, 5, Interface);
			setBounds(29309, 8, 96, 6, Interface);
			setBounds(29310, 8, 110, 7, Interface);
			setBounds(29311, 8, 125, 8, Interface);
			setBounds(29312, 8, 140, 9, Interface);
			setBounds(29313, 8, 155, 10, Interface);
			addHoverText(29295, "Tasks Completed 0/6", "View Achievements",
					TDA, 0, 65280, false, true, 150);
			addHoverText(29287, "Easy Tasks", "View Achievements", TDA, 0,
					0xFF981F, false, true, 150);
			addHoverText(29305, "Light 100 Fires", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29306, "Catch 100 Fish", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29307, "Kill 30 Rockcrabs", "View Achievements", TDA,
					0, 0xff0000, false, true, 150);
			addHoverText(29308, "Chop 100 Tress", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29309, "Earn 35 Pk Points", "View Achievements", TDA,
					0, 0xff0000, false, true, 150);
			addHoverText(29310, "Medium Tasks", "View Achievements", TDA, 0,
					0xFF981F, false, true, 150);
			addHoverText(29311, "Coming Soon...", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29312, "Coming Soon...", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
			addHoverText(29313, "Coming Soon...", "View Achievements", TDA, 0,
					0xff0000, false, true, 150);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void equipmentTab(TextDrawingArea[] wid) {
		RSInterface Interface = interfaceCache[1644];
		addSprite(15101, 0, "Interfaces/Equipment/bl");// cheap hax
		addSprite(15102, 1, "Interfaces/Equipment/bl");// cheap hax
		addSprite(15109, 2, "Interfaces/Equipment/bl");// cheap hax
		// removeSomething(15103);
		// removeSomething(15104);
		Interface.children[23] = 15101;
		Interface.childX[23] = 40;
		Interface.childY[23] = 205;
		Interface.children[24] = 15102;
		Interface.childX[24] = 110;
		Interface.childY[24] = 205;
		Interface.children[25] = 15109;
		Interface.childX[25] = 39;
		Interface.childY[25] = 240;
		Interface.children[26] = 27650;
		Interface.childX[26] = 0;
		Interface.childY[26] = 0;
		Interface = addInterface(27650);
		AddInterfaceButton(27651, 2, "Interfaces/Equipment/BOX",
				"Price-checker", 27659, 1, 40, 39);
		addTooltip(27659, "Price-checker");
		AddInterfaceButton(27653, 1, "Interfaces/Equipment/BOX",
				"Show Equipment Stats", 27655, 1, 40, 39);
		addTooltip(27655, "Show Equipment Stats");
		AddInterfaceButton(27654, 3, "Interfaces/Equipment/BOX",
				"Show items kept on death", 27657, 1, 40, 39);
		addTooltip(27657, "Items kept on death");
		setChildren(6, Interface);
		setBounds(27651, 75, 205, 0, Interface);
		setBounds(27653, 23, 205, 1, Interface);
		setBounds(27654, 127, 205, 2, Interface);
		setBounds(27659, 39, 240, 3, Interface);
		setBounds(27655, 39, 240, 4, Interface);
		setBounds(27657, 39, 240, 5, Interface);
	}

	/*public static void addBankHover1(int interfaceID, int actionType,
			int hoverid, int spriteId, String NAME, int Width, int Height,
			String Tooltip, int hoverId2, int hoverSpriteId,
			String hoverSpriteName, int hoverId3, String hoverDisabledText,
			int X, int Y) {
		RSInterface hover = addTabInterface(interfaceID);
		hover.id = interfaceID;
		hover.parentID = interfaceID;
		hover.type = 5;
		hover.atActionType = actionType;
		hover.contentType = 0;
		hover.aByte254 = 0;
		hover.sprite1 = imageLoader(spriteId, NAME);
		hover.width = Width;
		hover.tooltip = Tooltip;
		hover.height = Height;
		hover = addTabInterface(hoverid);
		hover.parentID = hoverid;
		hover.id = hoverid;
		hover.type = 0;
		hover.atActionType = 0;
		hover.width = 550;
		hover.height = 334;
		hover.isMouseoverTriggered = true;
		addSprite(hoverId2, hoverSpriteId, hoverSpriteId, hoverSpriteName, 0, 0);
		addHoverBox(hoverId3, interfaceID, hoverDisabledText,
				hoverDisabledText, 0, 0);
		setChildren(2, hover);
		setBounds(hoverId2, 15, 60, 0, hover);
		setBounds(hoverId3, X, Y, 1, hover);
	}*/

	public static void itemsOnDeath(TextDrawingArea[] wid) {
		RSInterface rsinterface = addInterface(17100);
		addSprite(17101, 2, 2);
		// addHover(17102,"Items Kept On Death/SPRITE", 1, 17, 17, "Close", 0,
		// 10602, 1);
		// addHovered(10602,"Items Kept On Death/SPRITE", 3, 17, 17, 10603);
		addText(17103, "Items kept on death", wid, 2, 0xff981f);
		addText(17104, "Items I will keep...", wid, 1, 0xff981f);
		addText(17105, "Items I will lose...", wid, 1, 0xff981f);
		addText(17106, "Info", wid, 1, 0xff981f);
		addText(17107, "DethWish", wid, 1, 0xffcc33);
		addText(17108, "", wid, 1, 0xffcc33);
		// rsinterface.scrollMax = 50;
		rsinterface.interfaceShown = false;
		rsinterface.children = new int[12];
		rsinterface.childX = new int[12];
		rsinterface.childY = new int[12];

		rsinterface.children[0] = 17101;
		rsinterface.childX[0] = 7;
		rsinterface.childY[0] = 8;
		rsinterface.children[1] = 15210;
		rsinterface.childX[1] = 478;
		rsinterface.childY[1] = 17;
		rsinterface.children[2] = 17103;
		rsinterface.childX[2] = 185;
		rsinterface.childY[2] = 18;
		rsinterface.children[3] = 17104;
		rsinterface.childX[3] = 22;
		rsinterface.childY[3] = 49;
		rsinterface.children[4] = 17105;
		rsinterface.childX[4] = 22;
		rsinterface.childY[4] = 109;
		rsinterface.children[5] = 17106;
		rsinterface.childX[5] = 347;
		rsinterface.childY[5] = 49;
		rsinterface.children[6] = 17107;
		rsinterface.childX[6] = 348;
		rsinterface.childY[6] = 270;
		rsinterface.children[7] = 17108;
		rsinterface.childX[7] = 401;
		rsinterface.childY[7] = 293;
		rsinterface.children[8] = 17115;
		rsinterface.childX[8] = 348;
		rsinterface.childY[8] = 64;
		rsinterface.children[9] = 10494;
		rsinterface.childX[9] = 26;
		rsinterface.childY[9] = 71;
		rsinterface.children[10] = 10600;
		rsinterface.childX[10] = 26;
		rsinterface.childY[10] = 129;
		rsinterface.children[11] = 15211;
		rsinterface.childX[11] = 478;
		rsinterface.childY[11] = 17;
		rsinterface = interfaceCache[10494];
		rsinterface.invSpritePadX = 6;
		rsinterface.invSpritePadY = 5;
		rsinterface = interfaceCache[10600];
		rsinterface.invSpritePadX = 6;
		rsinterface.invSpritePadY = 5;
	}

	public static void itemsOnDeathDATA(TextDrawingArea[] tda) {
		RSInterface RSinterface = addInterface(17115);
		addText(17109, "", 0xff981f, false, false, 0, tda, 0);
		addText(17110, "The normal amount of", 0xff981f, false, false, 0, tda,
				0);
		addText(17111, "items kept is three.", 0xff981f, false, false, 0, tda,
				0);
		addText(17112, "", 0xff981f, false, false, 0, tda, 0);
		addText(17113, "If you are skulled,", 0xff981f, false, false, 0, tda, 0);
		addText(17114, "you will lose all your", 0xff981f, false, false, 0,
				tda, 0);
		addText(17117, "items, unless an item", 0xff981f, false, false, 0, tda,
				0);
		addText(17118, "protecting prayer is", 0xff981f, false, false, 0, tda,
				0);
		addText(17119, "used.", 0xff981f, false, false, 0, tda, 0);
		addText(17120, "", 0xff981f, false, false, 0, tda, 0);
		addText(17121, "Item protecting prayers", 0xff981f, false, false, 0,
				tda, 0);
		addText(17122, "will allow you to keep", 0xff981f, false, false, 0,
				tda, 0);
		addText(17123, "one extra item.", 0xff981f, false, false, 0, tda, 0);
		addText(17124, "", 0xff981f, false, false, 0, tda, 0);
		addText(17125, "The items kept are", 0xff981f, false, false, 0, tda, 0);
		addText(17126, "selected by the server", 0xff981f, false, false, 0,
				tda, 0);
		addText(17127, "and include the most", 0xff981f, false, false, 0, tda,
				0);
		addText(17128, "expensive items you're", 0xff981f, false, false, 0,
				tda, 0);
		addText(17129, "carrying.", 0xff981f, false, false, 0, tda, 0);
		addText(17130, "", 0xff981f, false, false, 0, tda, 0);
		RSinterface.parentID = 17115;
		RSinterface.id = 17115;
		RSinterface.type = 0;
		RSinterface.atActionType = 0;
		RSinterface.contentType = 0;
		RSinterface.width = 130;
		RSinterface.height = 197;
		RSinterface.opacity = 0;
		RSinterface.hoverType = -1;
		RSinterface.scrollMax = 280;
		RSinterface.children = new int[20];
		RSinterface.childX = new int[20];
		RSinterface.childY = new int[20];
		RSinterface.children[0] = 17109;
		RSinterface.childX[0] = 0;
		RSinterface.childY[0] = 0;
		RSinterface.children[1] = 17110;
		RSinterface.childX[1] = 0;
		RSinterface.childY[1] = 12;
		RSinterface.children[2] = 17111;
		RSinterface.childX[2] = 0;
		RSinterface.childY[2] = 24;
		RSinterface.children[3] = 17112;
		RSinterface.childX[3] = 0;
		RSinterface.childY[3] = 36;
		RSinterface.children[4] = 17113;
		RSinterface.childX[4] = 0;
		RSinterface.childY[4] = 48;
		RSinterface.children[5] = 17114;
		RSinterface.childX[5] = 0;
		RSinterface.childY[5] = 60;
		RSinterface.children[6] = 17117;
		RSinterface.childX[6] = 0;
		RSinterface.childY[6] = 72;
		RSinterface.children[7] = 17118;
		RSinterface.childX[7] = 0;
		RSinterface.childY[7] = 84;
		RSinterface.children[8] = 17119;
		RSinterface.childX[8] = 0;
		RSinterface.childY[8] = 96;
		RSinterface.children[9] = 17120;
		RSinterface.childX[9] = 0;
		RSinterface.childY[9] = 108;
		RSinterface.children[10] = 17121;
		RSinterface.childX[10] = 0;
		RSinterface.childY[10] = 120;
		RSinterface.children[11] = 17122;
		RSinterface.childX[11] = 0;
		RSinterface.childY[11] = 132;
		RSinterface.children[12] = 17123;
		RSinterface.childX[12] = 0;
		RSinterface.childY[12] = 144;
		RSinterface.children[13] = 17124;
		RSinterface.childX[13] = 0;
		RSinterface.childY[13] = 156;
		RSinterface.children[14] = 17125;
		RSinterface.childX[14] = 0;
		RSinterface.childY[14] = 168;
		RSinterface.children[15] = 17126;
		RSinterface.childX[15] = 0;
		RSinterface.childY[15] = 180;
		RSinterface.children[16] = 17127;
		RSinterface.childX[16] = 0;
		RSinterface.childY[16] = 192;
		RSinterface.children[17] = 17128;
		RSinterface.childX[17] = 0;
		RSinterface.childY[17] = 204;
		RSinterface.children[18] = 17129;
		RSinterface.childX[18] = 0;
		RSinterface.childY[18] = 216;
		RSinterface.children[19] = 17130;
		RSinterface.childX[19] = 0;
		RSinterface.childY[19] = 228;
	}

	public static void itemsKeptOnDeath(TextDrawingArea[] tda) {
		RSInterface Interface = addInterface(55000);
		addSprite(55001, 1, "Death/SPRITE");
		addHoverButton(55002, "Death/SPRITE", 2, 17, 17, "Close", 250, 55002, 3);
		addHoveredButton(55003, "Death/SPRITE", 3, 17, 17, 55004);
		addText(55005, "22035", tda, 0, 0xff981f, false, true);
		addText(55006, "22036", tda, 0, 0xff981f, false, true);
		addText(55007, "22037", tda, 0, 0xff981f, false, true);
		addText(55008, "22038", tda, 0, 0xff981f, false, true);
		addText(55009, "22039", tda, 0, 0xff981f, false, true);
		addText(55010, "22040", tda, 1, 0xffcc33, false, true);
		setChildren(9, Interface);
		setBounds(55001, 7, 8, 0, Interface);
		setBounds(55002, 480, 18, 1, Interface);
		setBounds(55003, 480, 18, 2, Interface);
		setBounds(55005, 348, 98, 3, Interface);
		setBounds(55006, 348, 110, 4, Interface);
		setBounds(55007, 348, 122, 5, Interface);
		setBounds(55008, 348, 134, 6, Interface);
		setBounds(55009, 348, 146, 7, Interface);
		setBounds(55010, 398, 297, 8, Interface);
	}

	public static void addTextButton(int i, String s, String tooltip, int k,
			boolean l, boolean m, TextDrawingArea[] TDA, int j, int w) {
		RSInterface rsinterface = addInterface(i);
		rsinterface.parentID = i;
		rsinterface.id = i;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = w;
		rsinterface.height = 16;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = (byte) 0xFF981F;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.centerText = l;
		rsinterface.textShadow = m;
		rsinterface.textDrawingAreas = TDA[j];
		rsinterface.message = s;
		rsinterface.aString228 = "";
		rsinterface.anInt219 = 0xFF981F;
		rsinterface.textColor = 0xFF981F;
		rsinterface.tooltip = tooltip;
	}

	public static void slayerInterface(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(41000);
		addSprite(41001, 1, "Interfaces/SlayerInterface/IMAGE");
		addHoverButton(41002, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16,
				"Close window", 0, 41003, 1);
		addHoveredButton(41003, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16,
				41004);
		addHoverButton(41005, "", 0, 85, 20, "Buy", 0, 41006, 1);
		addHoverButton(41007, "", 0, 85, 20, "Learn", 0, 41008, 1);
		addHoverButton(41009, "", 0, 85, 20, "Assignment", 0, 41010, 1);
		addText(41011, "Slayer Points: ", tda, 3, 0xFF981F);
		addTextButton(41012, "Slayer Experience                           50",
				"Buy Slayer Experience", 0xFF981F, false, true, tda, 1, 400);
		addTextButton(41013, "Slayer's Respite                             25",
				"Buy Slayer's Respite", 0xFF981F, false, true, tda, 1, 401);
		addTextButton(41014,
				"Slayer Darts                                     35",
				"Buy Slayer Darts", 0xFF981F, false, true, tda, 1, 402);
		addTextButton(41015,
				"Broad Arrows                                    25",
				"Buy Broad Arrows", 0xFF981F, false, true, tda, 1, 403);
		setChildren(11, rsInterface);
		rsInterface.child(0, 41001, 12, 10);
		rsInterface.child(1, 41002, 473, 20);
		rsInterface.child(2, 41003, 473, 20);
		rsInterface.child(3, 41005, 21, 23);
		rsInterface.child(4, 41007, 107, 23);
		rsInterface.child(5, 41009, 193, 23);
		rsInterface.child(6, 41011, 98, 74);
		rsInterface.child(7, 41012, 124, 128);
		rsInterface.child(8, 41013, 125, 160);
		rsInterface.child(9, 41014, 125, 190);
		rsInterface.child(10, 41015, 124, 220);

	}

	public static void slayerInterfaceSub1(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(41500);
		addSprite(41501, 2, "Interfaces/SlayerInterface/IMAGE");
		addHoverButton(41502, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16,
				"Close window", 0, 41503, 1);
		addHoveredButton(41503, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16,
				41504);
		addHoverButton(41505, "", 0, 85, 20, "Buy", 0, 41506, 1);
		addHoverButton(41507, "", 0, 85, 20, "Learn", 0, 41508, 1);
		addHoverButton(41509, "", 0, 85, 20, "Assignment", 0, 41510, 1);
		addText(41511, "Slayer Points: ", tda, 3, 0xFF981F);
		setChildren(7, rsInterface);
		rsInterface.child(0, 41501, 12, 10);
		rsInterface.child(1, 41502, 473, 20);
		rsInterface.child(2, 41503, 473, 20);
		rsInterface.child(3, 41505, 21, 23);
		rsInterface.child(4, 41507, 107, 23);
		rsInterface.child(5, 41509, 193, 23);
		rsInterface.child(6, 41511, 98, 74);
	}

	public static void slayerInterfaceSub2(TextDrawingArea[] tda) {
		RSInterface rsInterface = addInterface(42000);
		addSprite(42001, 3, "Interfaces/SlayerInterface/IMAGE");
		addHoverButton(42002, "Interfaces/SlayerInterface/IMAGE", 4, 16, 16,
				"Close window", 0, 42003, 1);
		addHoveredButton(42003, "Interfaces/SlayerInterface/IMAGE", 5, 16, 16,
				42004);
		addHoverButton(42005, "", 0, 85, 20, "Buy", 0, 42006, 1);
		addHoverButton(42007, "", 0, 85, 20, "Learn", 0, 42008, 1);
		addHoverButton(42009, "", 0, 85, 20, "Assignment", 0, 42010, 1);
		addText(42011, "Slayer Points: ", tda, 3, 0xFF981F);
		addTextButton(42012, "Cancel Task",
				"Temporarily cancel your current slayer task", 0xFF981F, false,
				true, tda, 1, 300);
		addTextButton(42013, "Remove Task permanently",
				"Permanently remove this monster as a task", 0xFF981F, false,
				true, tda, 1, 305);
		addText(42014, "line 1", tda, 1, 0xFF981F);
		addText(42015, "line 2", tda, 1, 0xFF981F);
		addText(42016, "line 3", tda, 1, 0xFF981F);
		addText(42017, "line 4", tda, 1, 0xFF981F);
		addButton(42018, 6, "Interfaces/SlayerInterface/IMAGE",
				"Delete removed slayer task");
		addButton(42019, 6, "Interfaces/SlayerInterface/IMAGE",
				"Delete removed slayer task");
		addButton(42020, 6, "Interfaces/SlayerInterface/IMAGE",
				"Delete removed slayer task");
		addButton(42021, 6, "Interfaces/SlayerInterface/IMAGE",
				"Delete removed slayer task");
		setChildren(17, rsInterface);
		rsInterface.child(0, 42001, 12, 10);
		rsInterface.child(1, 42002, 473, 20);
		rsInterface.child(2, 42003, 473, 20);
		rsInterface.child(3, 42005, 21, 23);
		rsInterface.child(4, 42007, 107, 23);
		rsInterface.child(5, 42009, 193, 23);
		rsInterface.child(6, 42011, 98, 74);
		rsInterface.child(7, 42012, 71, 127);
		rsInterface.child(8, 42013, 71, 146);
		rsInterface.child(9, 42014, 71, 216);
		rsInterface.child(10, 42015, 71, 234);
		rsInterface.child(11, 42016, 71, 252);
		rsInterface.child(12, 42017, 71, 270);
		rsInterface.child(13, 42018, 303, 215);
		rsInterface.child(14, 42019, 303, 233);
		rsInterface.child(15, 42020, 303, 251);
		rsInterface.child(16, 42021, 303, 269);
	}

	public static void homeTeleport() {
		RSInterface RSInterface = addInterface(30000);
		RSInterface.tooltip = "Cast @gre@Lunar Home Teleport";
		RSInterface.id = 30000;
		RSInterface.parentID = 30000;
		RSInterface.type = 5;
		RSInterface.atActionType = 5;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 30001;
		RSInterface.sprite1 = imageLoader(1, "Lunar/SPRITE");
		RSInterface.width = 20;
		RSInterface.height = 20;
		RSInterface Int = addInterface(30001);
		Int.isMouseoverTriggered = true;
		Int.mOverInterToTrigger = -1;
		setChildren(1, Int);
		addLunarSprite(30002, 0, "SPRITE");
		setBounds(30002, 0, 0, 0, Int);
	}

	public static void addLunarSprite(int i, int j, String name) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = 5;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = LoadLunarSprite(j, name);
		RSInterface.width = 500;
		RSInterface.height = 500;
		RSInterface.tooltip = "";
	}

	public static void drawRune(int i, int id, String runeName) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.type = 5;
		RSInterface.atActionType = 0;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = 52;
		RSInterface.sprite1 = LoadLunarSprite(id, "RUNE");
		RSInterface.width = 500;
		RSInterface.height = 500;
	}

	public static void addButtons(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction) {
		RSInterface rsinterface = interfaceCache[id] = new RSInterface();
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 5;
		rsinterface.atActionType = atAction;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = (byte) 0;
		rsinterface.mOverInterToTrigger = mOver;
		rsinterface.sprite1 = imageLoader(sid, spriteName);
		rsinterface.sprite2 = imageLoader(sid, spriteName);
		rsinterface.width = rsinterface.sprite1.myWidth;
		rsinterface.height = rsinterface.sprite2.myHeight;
		rsinterface.tooltip = tooltip;
		rsinterface.inventoryhover = true;
	}

	public static void addLunar2RunesSmallBox(int ID, int r1, int r2, int ra1,
			int ra2, int rune1, int lvl, String name, String descr,
			TextDrawingArea[] TDA, int sid, int suo, int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast On";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[3];
		rsInterface.anIntArray212 = new int[3];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = lvl;
		rsInterface.valueIndexArray = new int[3][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[3];
		rsInterface.valueIndexArray[2][0] = 1;
		rsInterface.valueIndexArray[2][1] = 6;
		rsInterface.valueIndexArray[2][2] = 0;
		rsInterface.sprite2 = imageLoader(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = imageLoader(sid, "Lunar/LUNAROFF");
		RSInterface INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		// setChildren(7, INT);
		// addLunarSprite(ID+2, 0, "BOX");
		// setBounds(ID+2, 0, 0, 0, INT);
		// addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52,
		// TDA, 1);
		// setBounds(ID+3, 90, 4, 1, INT);
		// addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		// setBounds(ID+4, 90, 19, 2, INT);
		// setBounds(30016, 37, 35, 3, INT);//Rune
		// setBounds(rune1, 112, 35, 4, INT);//Rune
		// addRuneText(ID+5, ra1+1, r1, TDA);
		// setBounds(ID+5, 50, 66, 5, INT);
		// addRuneText(ID+6, ra2+1, r2, TDA);
		// setBounds(ID+6, 123, 66, 6, INT);

	}

	public static void addRuneText(int ID, int runeAmount, int RuneID,
			TextDrawingArea[] font) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 4;
		rsInterface.atActionType = 0;
		rsInterface.contentType = 0;
		rsInterface.width = 0;
		rsInterface.height = 14;
		rsInterface.aByte254 = 0;
		rsInterface.mOverInterToTrigger = -1;
		rsInterface.anIntArray245 = new int[1];
		rsInterface.anIntArray212 = new int[1];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = runeAmount;
		rsInterface.valueIndexArray = new int[1][4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = RuneID;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.centerText = true;
		rsInterface.textDrawingAreas = font[0];
		// rsInterface.textShadowed = true;
		rsInterface.message = "%1/" + runeAmount + "";
		rsInterface.message = "";
		// rsInterface.disabledColour = 12582912;
		// rsInterface.enabledColour = 49152;
	}

	public static void addLunar3RunesSmallBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = imageLoader(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = imageLoader(sid, "Lunar/LUNAROFF");
		RSInterface INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		// setChildren(9, INT);
		// addLunarSprite(ID+2, 0, "BOX");
		// setBounds(ID+2, 0, 0, 0, INT);
		// addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52,
		// TDA, 1);setBounds(ID+3, 90, 4, 1, INT);
		// addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		// setBounds(ID+4, 90, 19, 2, INT);
		// setBounds(30016, 14, 35, 3, INT);
		// setBounds(rune1, 74, 35, 4, INT);
		// setBounds(rune2, 130, 35, 5, INT);
		// addRuneText(ID+5, ra1+1, r1, TDA);
		// setBounds(ID+5, 26, 66, 6, INT);
		// addRuneText(ID+6, ra2+1, r2, TDA);
		// setBounds(ID+6, 87, 66, 7, INT);
		// addRuneText(ID+7, ra3+1, r3, TDA);
		// setBounds(ID+7, 142, 66, 8, INT);
	}

	public static void addLunar3RunesBigBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = imageLoader(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = imageLoader(sid, "Lunar/LUNAROFF");
		RSInterface INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		// setChildren(9, INT);
		// addLunarSprite(ID+2, 1, "BOX");
		// setBounds(ID+2, 0, 0, 0, INT);
		// addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52,
		// TDA, 1);setBounds(ID+3, 90, 4, 1, INT);
		// addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		// setBounds(ID+4, 90, 21, 2, INT);
		// setBounds(30016, 14, 48, 3, INT);
		// setBounds(rune1, 74, 48, 4, INT);
		// setBounds(rune2, 130, 48, 5, INT);
		// addRuneText(ID+5, ra1+1, r1, TDA);
		// setBounds(ID+5, 26, 79, 6, INT);
		// addRuneText(ID+6, ra2+1, r2, TDA);
		// setBounds(ID+6, 87, 79, 7, INT);
		// addRuneText(ID+7, ra3+1, r3, TDA);
		// setBounds(ID+7, 142, 79, 8, INT);
	}

	public static void addLunar3RunesLargeBox(int ID, int r1, int r2, int r3,
			int ra1, int ra2, int ra3, int rune1, int rune2, int lvl,
			String name, String descr, TextDrawingArea[] TDA, int sid, int suo,
			int type) {
		RSInterface rsInterface = addInterface(ID);
		rsInterface.id = ID;
		rsInterface.parentID = 1151;
		rsInterface.type = 5;
		rsInterface.atActionType = type;
		rsInterface.contentType = 0;
		rsInterface.mOverInterToTrigger = ID + 1;
		rsInterface.spellUsableOn = suo;
		rsInterface.selectedActionName = "Cast on";
		rsInterface.width = 20;
		rsInterface.height = 20;
		rsInterface.tooltip = "Cast @gre@" + name;
		rsInterface.spellName = name;
		rsInterface.anIntArray245 = new int[4];
		rsInterface.anIntArray212 = new int[4];
		rsInterface.anIntArray245[0] = 3;
		rsInterface.anIntArray212[0] = ra1;
		rsInterface.anIntArray245[1] = 3;
		rsInterface.anIntArray212[1] = ra2;
		rsInterface.anIntArray245[2] = 3;
		rsInterface.anIntArray212[2] = ra3;
		rsInterface.anIntArray245[3] = 3;
		rsInterface.anIntArray212[3] = lvl;
		rsInterface.valueIndexArray = new int[4][];
		rsInterface.valueIndexArray[0] = new int[4];
		rsInterface.valueIndexArray[0][0] = 4;
		rsInterface.valueIndexArray[0][1] = 3214;
		rsInterface.valueIndexArray[0][2] = r1;
		rsInterface.valueIndexArray[0][3] = 0;
		rsInterface.valueIndexArray[1] = new int[4];
		rsInterface.valueIndexArray[1][0] = 4;
		rsInterface.valueIndexArray[1][1] = 3214;
		rsInterface.valueIndexArray[1][2] = r2;
		rsInterface.valueIndexArray[1][3] = 0;
		rsInterface.valueIndexArray[2] = new int[4];
		rsInterface.valueIndexArray[2][0] = 4;
		rsInterface.valueIndexArray[2][1] = 3214;
		rsInterface.valueIndexArray[2][2] = r3;
		rsInterface.valueIndexArray[2][3] = 0;
		rsInterface.valueIndexArray[3] = new int[3];
		rsInterface.valueIndexArray[3][0] = 1;
		rsInterface.valueIndexArray[3][1] = 6;
		rsInterface.valueIndexArray[3][2] = 0;
		rsInterface.sprite2 = imageLoader(sid, "Lunar/LUNARON");
		rsInterface.sprite1 = imageLoader(sid, "Lunar/LUNAROFF");
		RSInterface INT = addInterface(ID + 1);
		INT.isMouseoverTriggered = true;
		INT.mOverInterToTrigger = -1;
		// setChildren(9, INT);
		// addLunarSprite(ID+2, 2, "BOX");
		// setBounds(ID+2, 0, 0, 0, INT);
		// addText(ID+3, "Level "+(lvl+1)+": "+name, 0xFF981F, true, true, 52,
		// TDA, 1);
		// setBounds(ID+3, 90, 4, 1, INT);
		// addText(ID+4, descr, 0xAF6A1A, true, true, 52, TDA, 0);
		// setBounds(ID+4, 90, 34, 2, INT);
		// setBounds(30016, 14, 61, 3, INT);
		// setBounds(rune1, 74, 61, 4, INT);
		// setBounds(rune2, 130, 61, 5, INT);
		// addRuneText(ID+5, ra1+1, r1, TDA);
		// setBounds(ID+5, 26, 92, 6, INT);
		// addRuneText(ID+6, ra2+1, r2, TDA);
		// setBounds(ID+6, 87, 92, 7, INT);
		// addRuneText(ID+7, ra3+1, r3, TDA);
		// setBounds(ID+7, 142, 92, 8, INT);
	}

	private static Sprite LoadLunarSprite(int i, String s) {
		Sprite sprite = imageLoader(i, "/Lunar/" + s);
		return sprite;
	}

	public static void Levelup(TextDrawingArea[] tda) {
		RSInterface text = interfaceCache[7202];
		RSInterface attack = interfaceCache[6247];
		RSInterface defence = interfaceCache[6253];
		RSInterface str = interfaceCache[6206];
		RSInterface hits = interfaceCache[6216];
		RSInterface rng = interfaceCache[4443];
		RSInterface pray = interfaceCache[6242];
		RSInterface mage = interfaceCache[6211];
		RSInterface cook = interfaceCache[6226];
		RSInterface wood = interfaceCache[4272];
		RSInterface flet = interfaceCache[6231];
		RSInterface fish = interfaceCache[6258];
		RSInterface fire = interfaceCache[4282];
		RSInterface craf = interfaceCache[6263];
		RSInterface smit = interfaceCache[6221];
		RSInterface mine = interfaceCache[4416];
		RSInterface herb = interfaceCache[6237];
		RSInterface agil = interfaceCache[4277];
		RSInterface thie = interfaceCache[4261];
		RSInterface slay = interfaceCache[12122];
		RSInterface farm = interfaceCache[5267];
		RSInterface rune = interfaceCache[4267];
		RSInterface cons = interfaceCache[7267];
		RSInterface hunt = interfaceCache[8267];
		RSInterface summ = addInterface(9267);
		RSInterface dung = addInterface(10267);
		addSprite(17878, 0, "Interfaces/skillchat/skill");
		addSprite(17879, 1, "Interfaces/skillchat/skill");
		addSprite(17880, 2, "Interfaces/skillchat/skill");
		addSprite(17881, 3, "Interfaces/skillchat/skill");
		addSprite(17882, 4, "Interfaces/skillchat/skill");
		addSprite(17883, 5, "Interfaces/skillchat/skill");
		addSprite(17884, 6, "Interfaces/skillchat/skill");
		addSprite(17885, 7, "Interfaces/skillchat/skill");
		addSprite(17886, 8, "Interfaces/skillchat/skill");
		addSprite(17887, 9, "Interfaces/skillchat/skill");
		addSprite(17888, 10, "Interfaces/skillchat/skill");
		addSprite(17889, 11, "Interfaces/skillchat/skill");
		addSprite(17890, 12, "Interfaces/skillchat/skill");
		addSprite(17891, 13, "Interfaces/skillchat/skill");
		addSprite(17892, 14, "Interfaces/skillchat/skill");
		addSprite(17893, 15, "Interfaces/skillchat/skill");
		addSprite(17894, 16, "Interfaces/skillchat/skill");
		addSprite(17895, 17, "Interfaces/skillchat/skill");
		addSprite(17896, 18, "Interfaces/skillchat/skill");
		addSprite(11897, 19, "Interfaces/skillchat/skill");
		addSprite(17898, 20, "Interfaces/skillchat/skill");
		addSprite(17899, 21, "Interfaces/skillchat/skill");
		addSprite(17900, 22, "Interfaces/skillchat/skill");
		addSprite(17901, 23, "Interfaces/skillchat/skill");
		addSprite(17902, 24, "Interfaces/skillchat/skill");
		setChildren(4, attack);
		setBounds(17878, 20, 30, 0, attack);
		setBounds(4268, 80, 15, 1, attack);
		setBounds(4269, 80, 45, 2, attack);
		setBounds(358, 95, 75, 3, attack);
		setChildren(4, defence);
		setBounds(17879, 20, 30, 0, defence);
		setBounds(4268, 80, 15, 1, defence);
		setBounds(4269, 80, 45, 2, defence);
		setBounds(358, 95, 75, 3, defence);
		setChildren(4, str);
		setBounds(17880, 20, 30, 0, str);
		setBounds(4268, 80, 15, 1, str);
		setBounds(4269, 80, 45, 2, str);
		setBounds(358, 95, 75, 3, str);
		setChildren(4, hits);
		setBounds(17881, 20, 30, 0, hits);
		setBounds(4268, 80, 15, 1, hits);
		setBounds(4269, 80, 45, 2, hits);
		setBounds(358, 95, 75, 3, hits);
		setChildren(4, rng);
		setBounds(17882, 20, 30, 0, rng);
		setBounds(4268, 80, 15, 1, rng);
		setBounds(4269, 80, 45, 2, rng);
		setBounds(358, 95, 75, 3, rng);
		setChildren(4, pray);
		setBounds(17883, 20, 30, 0, pray);
		setBounds(4268, 80, 15, 1, pray);
		setBounds(4269, 80, 45, 2, pray);
		setBounds(358, 95, 75, 3, pray);
		setChildren(4, mage);
		setBounds(17884, 20, 30, 0, mage);
		setBounds(4268, 80, 15, 1, mage);
		setBounds(4269, 80, 45, 2, mage);
		setBounds(358, 95, 75, 3, mage);
		setChildren(4, cook);
		setBounds(17885, 20, 30, 0, cook);
		setBounds(4268, 80, 15, 1, cook);
		setBounds(4269, 80, 45, 2, cook);
		setBounds(358, 95, 75, 3, cook);
		setChildren(4, wood);
		setBounds(17886, 20, 30, 0, wood);
		setBounds(4268, 80, 15, 1, wood);
		setBounds(4269, 80, 45, 2, wood);
		setBounds(358, 95, 75, 3, wood);
		setChildren(4, flet);
		setBounds(17887, 20, 30, 0, flet);
		setBounds(4268, 80, 15, 1, flet);
		setBounds(4269, 80, 45, 2, flet);
		setBounds(358, 95, 75, 3, flet);
		setChildren(4, fish);
		setBounds(17888, 20, 30, 0, fish);
		setBounds(4268, 80, 15, 1, fish);
		setBounds(4269, 80, 45, 2, fish);
		setBounds(358, 95, 75, 3, fish);
		setChildren(4, fire);
		setBounds(17889, 20, 30, 0, fire);
		setBounds(4268, 80, 15, 1, fire);
		setBounds(4269, 80, 45, 2, fire);
		setBounds(358, 95, 75, 3, fire);
		setChildren(4, craf);
		setBounds(17890, 20, 30, 0, craf);
		setBounds(4268, 80, 15, 1, craf);
		setBounds(4269, 80, 45, 2, craf);
		setBounds(358, 95, 75, 3, craf);
		setChildren(4, smit);
		setBounds(17891, 20, 30, 0, smit);
		setBounds(4268, 80, 15, 1, smit);
		setBounds(4269, 80, 45, 2, smit);
		setBounds(358, 95, 75, 3, smit);
		setChildren(4, mine);
		setBounds(17892, 20, 30, 0, mine);
		setBounds(4268, 80, 15, 1, mine);
		setBounds(4269, 80, 45, 2, mine);
		setBounds(358, 95, 75, 3, mine);
		setChildren(4, herb);
		setBounds(17893, 20, 30, 0, herb);
		setBounds(4268, 80, 15, 1, herb);
		setBounds(4269, 80, 45, 2, herb);
		setBounds(358, 95, 75, 3, herb);
		setChildren(4, agil);
		setBounds(17894, 20, 30, 0, agil);
		setBounds(4268, 80, 15, 1, agil);
		setBounds(4269, 80, 45, 2, agil);
		setBounds(358, 95, 75, 3, agil);
		setChildren(4, thie);
		setBounds(17895, 20, 30, 0, thie);
		setBounds(4268, 80, 15, 1, thie);
		setBounds(4269, 80, 45, 2, thie);
		setBounds(358, 95, 75, 3, thie);
		setChildren(4, slay);
		setBounds(17896, 20, 30, 0, slay);
		setBounds(4268, 80, 15, 1, slay);
		setBounds(4269, 80, 45, 2, slay);
		setBounds(358, 95, 75, 3, slay);
		setChildren(3, farm);
		setBounds(4268, 80, 15, 0, farm);
		setBounds(4269, 80, 45, 1, farm);
		setBounds(358, 95, 75, 2, farm);
		setChildren(4, rune);
		setBounds(17898, 20, 30, 0, rune);
		setBounds(4268, 80, 15, 1, rune);
		setBounds(4269, 80, 45, 2, rune);
		setBounds(358, 95, 75, 3, rune);
		setChildren(3, cons);
		setBounds(4268, 80, 15, 0, cons);
		setBounds(4269, 80, 45, 1, cons);
		setBounds(358, 95, 75, 2, cons);
		setChildren(3, hunt);
		setBounds(4268, 80, 15, 0, hunt);
		setBounds(4269, 80, 45, 1, hunt);
		setBounds(358, 95, 75, 2, hunt);
		setChildren(4, summ);
		setBounds(17901, 20, 30, 0, summ);
		setBounds(4268, 80, 15, 1, summ);
		setBounds(4269, 80, 45, 2, summ);
		setBounds(358, 95, 75, 3, summ);
		setChildren(4, dung);
		setBounds(17902, 20, 30, 0, dung);
		setBounds(4268, 80, 15, 1, dung);
		setBounds(4269, 80, 45, 2, dung);
		setBounds(358, 95, 75, 3, dung);
	}

	public static void addActionButton(int id, int sprite, int sprite2,
			int width, int height, String s) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = CustomSpriteLoader(sprite, "");
		if (sprite2 == sprite)
			rsi.sprite2 = CustomSpriteLoader(sprite, "a");
		else
			rsi.sprite2 = CustomSpriteLoader(sprite2, "");
		rsi.tooltip = s;
		rsi.contentType = 0;
		rsi.atActionType = 1;
		rsi.width = width;
		rsi.mOverInterToTrigger = 52;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction, int width, int height) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = atAction;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = mOver;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = tooltip;
		tab.inventoryhover = true;
	}

	public static void addText(int id, String text, TextDrawingArea wid[],
			int idx, int color) {
		RSInterface rsinterface = addTab(id);
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 4;
		rsinterface.atActionType = 0;
		rsinterface.width = 174;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.centerText = false;
		rsinterface.textShadow = true;
		rsinterface.textDrawingAreas = wid[idx];
		rsinterface.message = text;
		rsinterface.aString228 = "";
		rsinterface.textColor = color;
		rsinterface.anInt219 = 0;
		rsinterface.anInt216 = 0;
		rsinterface.anInt239 = 0;
	}

	public static void sprite1(int id, int sprite) {
		RSInterface class9 = interfaceCache[id];
		class9.sprite1 = CustomSpriteLoader(sprite, "");
	}

	public static RSInterface addInterface(int id) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.id = id;
		rsi.parentID = id;
		rsi.width = 512;
		rsi.height = 334;
		return rsi;
	}

	public static void addHoverText(int id, String text, String tooltip,
			TextDrawingArea tda[], int idx, int color, boolean center,
			boolean textShadowed, int width) {
		RSInterface rsinterface = addInterface(id);
		rsinterface.id = id;
		rsinterface.parentID = id;
		rsinterface.type = 4;
		rsinterface.atActionType = 1;
		rsinterface.width = width;
		rsinterface.height = 11;
		rsinterface.contentType = 0;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = -1;
		rsinterface.centerText = center;
		rsinterface.textShadow = textShadowed;
		rsinterface.textDrawingAreas = tda[idx];
		rsinterface.message = text;
		rsinterface.aString228 = "";
		rsinterface.textColor = color;
		rsinterface.anInt219 = 0;
		rsinterface.anInt216 = 0xffffff;
		rsinterface.anInt239 = 0;
		rsinterface.tooltip = tooltip;
	}

	public static RSInterface addTab(int i) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.id = i;
		rsinterface.parentID = i;
		rsinterface.type = 0;
		rsinterface.atActionType = 0;
		rsinterface.contentType = 0;
		rsinterface.width = 512;
		rsinterface.height = 334;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = 0;
		return rsinterface;
	}

	public static void addConfigButton(int ID, int pID, int bID, int bID2,
			String bName, int width, int height, String tT, int configID,
			int aT, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.parentID = pID;
		Tab.id = ID;
		Tab.type = 5;
		Tab.atActionType = aT;
		Tab.contentType = 0;
		Tab.width = width;
		Tab.height = height;
		Tab.aByte254 = 0;
		Tab.mOverInterToTrigger = -1;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configID;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(bID, bName);
		Tab.sprite2 = imageLoader(bID2, bName);
		Tab.tooltip = tT;
	}

	public static void drawBlackBox(int xPos, int yPos) {
		// /Light Coloured Borders\\\
		DrawingArea.drawPixels(71, yPos - 1, xPos - 2, 0x726451, 1); // Left
																		// line
		DrawingArea.drawPixels(69, yPos, xPos + 174, 0x726451, 1); // Right line
		DrawingArea.drawPixels(1, yPos - 2, xPos - 2, 0x726451, 178); // Top
																		// Line
		DrawingArea.drawPixels(1, yPos + 68, xPos, 0x726451, 174); // Bottom
																	// Line

		// /Dark Coloured Borders\\\
		DrawingArea.drawPixels(71, yPos - 1, xPos - 1, 0x2E2B23, 1); // Left
																		// line
		DrawingArea.drawPixels(71, yPos - 1, xPos + 175, 0x2E2B23, 1); // Right
																		// line
		DrawingArea.drawPixels(1, yPos - 1, xPos, 0x2E2B23, 175); // Top line
		DrawingArea.drawPixels(1, yPos + 69, xPos, 0x2E2B23, 175); // Top line

		// /Black Box\\\
		DrawingArea.method335(0x000000, yPos, 174, 68, 220, xPos); // Yes
																	// method335
																	// is
																	// galkons
																	// opacity
																	// method
	}

	public Sprite disabledHover;
	public Sprite enabledHover;

	public static void addPrayer(int i, int configId, int configFrame,
			int requiredValues, int spriteID, String prayerName) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = 5608;
		tab.type = 5;
		tab.atActionType = 4;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.sprite1 = imageLoader(0, "PRAYERGLOW");
		tab.sprite2 = imageLoader(1, "PRAYERGLOW");
		tab.width = 34;
		tab.height = 34;
		tab.anIntArray245 = new int[1];
		tab.anIntArray212 = new int[1];
		tab.anIntArray245[0] = 1;
		tab.anIntArray212[0] = configId;
		tab.valueIndexArray = new int[1][3];
		tab.valueIndexArray[0][0] = 5;
		tab.valueIndexArray[0][1] = configFrame;
		tab.valueIndexArray[0][2] = 0;
		// tab.tooltip = "Activate@or2@ " + prayerName;
		tab.tooltip = "Select";
		RSInterface tab2 = addTabInterface(i + 1);
		tab2.id = i + 1;
		tab2.parentID = 5608;
		tab2.type = 5;
		tab2.atActionType = 0;
		tab2.contentType = 0;
		tab2.aByte254 = 0;
		tab2.mOverInterToTrigger = -1;
		tab2.sprite1 = imageLoader(spriteID, "Prayer/PRAYON");
		tab2.sprite2 = imageLoader(spriteID, "Prayer/PRAYOFF");
		tab2.width = 34;
		tab2.height = 34;
		tab2.anIntArray245 = new int[1];
		tab2.anIntArray212 = new int[1];
		tab2.anIntArray245[0] = 2;
		tab2.anIntArray212[0] = requiredValues + 1;
		tab2.valueIndexArray = new int[1][3];
		tab2.valueIndexArray[0][0] = 2;
		tab2.valueIndexArray[0][1] = 5;
		tab2.valueIndexArray[0][2] = 0;
	}

	public static void addToggleButton(int id, int sprite, int setconfig,
			int width, int height, String s) {
		RSInterface rsi = addInterface(id);
		rsi.sprite1 = CustomSpriteLoader(sprite, "");
		rsi.sprite2 = CustomSpriteLoader(sprite, "a");
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray212[0] = 1;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = setconfig;
		rsi.valueIndexArray[0][2] = 0;
		rsi.atActionType = 4;
		rsi.width = width;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
		rsi.tooltip = s;
	}

	public static void removeSomething(int id) {
		@SuppressWarnings("unused")
		RSInterface rsi = interfaceCache[id] = new RSInterface();
	}

	public static void setBounds(int ID, int X, int Y, int frame,
			RSInterface RSinterface) {
		RSinterface.children[frame] = ID;
		RSinterface.childX[frame] = X;
		RSinterface.childY[frame] = Y;
	}

	public static void textSize(int id, TextDrawingArea tda[], int idx) {
		RSInterface rsi = interfaceCache[id];
		rsi.textDrawingAreas = tda[idx];
	}

	/**
	 * Adds your current character to an interface.
	 **/

	protected static void addOldPrayer(int id, String prayerName) {
		RSInterface rsi = interfaceCache[id];
		rsi.tooltip = "Activate@or2@ " + prayerName;
	}

	public static void addPrayerHover(int i, int hoverID, int prayerSpriteID,
			String hoverText) {
		RSInterface Interface = addTabInterface(i);
		Interface.id = i;
		Interface.parentID = 5608;
		Interface.type = 5;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = hoverID;
		Interface.sprite2 = imageLoader(0, "tabs/prayer/hover/PRAYERH");
		Interface.sprite1 = imageLoader(0, "tabs/prayer/hover/PRAYERH");
		Interface.width = 34;
		Interface.height = 34;

		Interface = addTabInterface(hoverID);
		Interface.id = hoverID;
		Interface.parentID = 5608;
		Interface.type = 0;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.aByte254 = 0;
		Interface.mOverInterToTrigger = -1;
		Interface.width = 512;
		Interface.height = 334;
		Interface.isMouseoverTriggered = true;
		addBox(hoverID + 1, 0, false, 0x000000, hoverText);
		setChildren(1, Interface);
		setBounds(hoverID + 1, 0, 0, 0, Interface);
	}

	public static void addChar(int ID) {
		RSInterface t = interfaceCache[ID] = new RSInterface();
		t.id = ID;
		t.parentID = ID;
		t.type = 6;
		t.atActionType = 0;
		t.contentType = 328;
		t.width = 136;
		t.height = 168;
		t.aByte254 = 0;
		t.mOverInterToTrigger = 0;
		t.modelZoom = 560;
		t.modelRotation1 = 150;
		t.modelRotation2 = 0;
		t.anInt257 = -1;
		t.anInt258 = -1;
	}

	public static void addCacheSprite(int id, int sprite1, int sprite2,
			String sprites) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		rsi.sprite1 = method207(sprite1, aClass44, sprites);
		rsi.sprite2 = method207(sprite2, aClass44, sprites);
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
	}

	public void specialBar(int id, TextDrawingArea[] tda) // 7599
	{
		addActionButton(id - 12, 7587, -1, 150, 26, "Use @gre@Special Attack");
		for (int i = id - 11; i < id; i++)
			removeSomething(i);

		RSInterface rsi = interfaceCache[id - 12];
		rsi.width = 150;
		rsi.height = 26;
		rsi.mOverInterToTrigger = 40005;

		rsi = interfaceCache[id];
		rsi.width = 150;
		rsi.height = 26;

		rsi.child(0, id - 12, 0, 0);

		rsi.child(12, id + 1, 3, 7);

		rsi.child(23, id + 12, 16, 8);

		for (int i = 13; i < 23; i++) {
			rsi.childY[i] -= 1;
		}

		rsi = interfaceCache[id + 1];
		rsi.type = 5;
		rsi.sprite1 = CustomSpriteLoader(7600, "");

		for (int i = id + 2; i < id + 12; i++) {
			rsi = interfaceCache[i];
			rsi.type = 5;
		}

		sprite1(id + 2, 7601);
		sprite1(id + 3, 7602);
		sprite1(id + 4, 7603);
		sprite1(id + 5, 7604);
		sprite1(id + 6, 7605);
		sprite1(id + 7, 7606);
		sprite1(id + 8, 7607);
		sprite1(id + 9, 7608);
		sprite1(id + 10, 7609);
		sprite1(id + 11, 7610);

		rsi = addInterface(40005);
		rsi.isMouseoverTriggered = true;
		rsi.type = 0;
		rsi.atActionType = 0;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = 40005;
		rsi.id = 40005;
		addBox(40006, 0, false, 0x000000,
				"Select to perform a special\nattack.");
		setChildren(1, rsi);
		setBounds(40006, 0, 0, 0, rsi);
	}

	public static void addAttackHover(int id, int hoverID, String hoverText,
			TextDrawingArea[] TDA) {
		RSInterface rsi = interfaceCache[id];
		rsi.mOverInterToTrigger = hoverID;

		rsi = addInterface(hoverID);
		rsi.isMouseoverTriggered = true;
		rsi.type = 0;
		rsi.atActionType = 0;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = hoverID;
		rsi.id = hoverID;
		addBox(hoverID + 1, 0, false, 0x000000, hoverText);
		setChildren(1, rsi);
		setBounds(hoverID + 1, 0, 0, 0, rsi);
	}

	public static void addAttackText(int id, String text,
			TextDrawingArea tda[], int idx, int color, boolean centered) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		if (centered)
			rsi.centerText = true;
		rsi.textShadow = true;
		rsi.textDrawingAreas = tda[idx];
		rsi.message = text;
		rsi.textColor = color;
		rsi.id = id;
		rsi.type = 4;
	}

	public static void addAttackStyleButton2(int id, int sprite, int setconfig,
			int width, int height, String s, int hoverID, int hW, int hH,
			String hoverText, TextDrawingArea[] TDA) {
		RSInterface rsi = addInterface(id);
		rsi.sprite1 = CustomSpriteLoader(sprite, "");
		rsi.sprite2 = CustomSpriteLoader(sprite, "a");
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray212[0] = 1;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = setconfig;
		rsi.valueIndexArray[0][2] = 0;
		rsi.atActionType = 4;
		rsi.width = width;
		rsi.mOverInterToTrigger = hoverID;
		rsi.parentID = id;
		rsi.id = id;
		rsi.type = 5;
		rsi.height = height;
		rsi.tooltip = s;
		rsi = addInterface(hoverID);
		rsi.isMouseoverTriggered = true;
		rsi.type = 0;
		rsi.atActionType = 0;
		rsi.mOverInterToTrigger = -1;
		rsi.parentID = hoverID;
		rsi.id = hoverID;
		addBox(hoverID + 1, 0, false, 0x000000, hoverText);
		setChildren(1, rsi);
		setBounds(hoverID + 1, 0, 0, 0, rsi);
	}

	public static void addBox(int id, int byte1, boolean filled, int color,
			String text) {
		RSInterface Interface = addInterface(id);
		Interface.id = id;
		Interface.parentID = id;
		Interface.type = 9;
		Interface.aByte254 = (byte) byte1;
		Interface.aBoolean227 = filled;
		Interface.mOverInterToTrigger = -1;
		Interface.atActionType = 0;
		Interface.contentType = 0;
		Interface.textColor = color;
		Interface.message = text;
	}

	public static void setChildren(int total, RSInterface i) {
		i.children = new int[total];
		i.childX = new int[total];
		i.childY = new int[total];
	}

	protected static Sprite CustomSpriteLoader(int id, String s) {
		long l = (TextClass.method585(s) << 8) + id;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null) {
			return sprite;
		}
		try {
			sprite = new Sprite("/Attack/" + id + s);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	public static void addTooltipBox(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.parentID = id;
		rsi.type = 9;
		rsi.message = text;
	}

	public static void addTooltip(int id, String text) {
		RSInterface rsi = addInterface(id);
		rsi.id = id;
		rsi.type = 0;
		rsi.isMouseoverTriggered = true;
		rsi.mOverInterToTrigger = -1;
		addTooltipBox(id + 1, text);
		rsi.totalChildren(1);
		rsi.child(0, id + 1, 0, 0);
	}

	public static void addText(int i, String s, int k, boolean l, boolean m,
			int a, TextDrawingArea[] TDA, int j) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.parentID = i;
		RSInterface.id = i;
		RSInterface.type = 4;
		RSInterface.atActionType = 0;
		RSInterface.width = 0;
		RSInterface.height = 0;
		RSInterface.contentType = 0;
		RSInterface.aByte254 = 0;
		RSInterface.mOverInterToTrigger = a;
		RSInterface.centerText = l;
		RSInterface.textShadow = m;
		RSInterface.textDrawingAreas = TDA[j];
		RSInterface.message = s;
		RSInterface.aString228 = "";
		RSInterface.textColor = k;
	}

	public static void addSprite(int i, int j, int k) {
		RSInterface rsinterface = interfaceCache[i] = new RSInterface();
		rsinterface.id = i;
		rsinterface.parentID = i;
		rsinterface.type = 5;
		rsinterface.atActionType = 1;
		rsinterface.contentType = 0;
		rsinterface.width = 20;
		rsinterface.height = 20;
		rsinterface.aByte254 = 0;
		rsinterface.mOverInterToTrigger = 52;
		rsinterface.sprite1 = imageLoader(j, "Equipment/SPRITE");
		rsinterface.sprite2 = imageLoader(k, "Equipment/SPRITE");
	}

	public static void addHover(int i, int aT, int cT, int hoverid, int sId,
			String NAME, int W, int H, String tip) {
		RSInterface rsinterfaceHover = addInterface(i);
		rsinterfaceHover.id = i;
		rsinterfaceHover.parentID = i;
		rsinterfaceHover.type = 5;
		rsinterfaceHover.atActionType = aT;
		rsinterfaceHover.contentType = cT;
		rsinterfaceHover.mOverInterToTrigger = hoverid;
		rsinterfaceHover.sprite1 = imageLoader(sId, NAME);
		rsinterfaceHover.sprite2 = imageLoader(sId, NAME);
		rsinterfaceHover.width = W;
		rsinterfaceHover.height = H;
		rsinterfaceHover.tooltip = tip;
	}

	public static void addHovered(int i, int j, String imageName, int w, int h,
			int IMAGEID) {
		RSInterface rsinterfaceHover = addInterface(i);
		rsinterfaceHover.parentID = i;
		rsinterfaceHover.id = i;
		rsinterfaceHover.type = 0;
		rsinterfaceHover.atActionType = 0;
		rsinterfaceHover.width = w;
		rsinterfaceHover.height = h;
		rsinterfaceHover.isMouseoverTriggered = true;
		rsinterfaceHover.mOverInterToTrigger = -1;
		addSprite(IMAGEID, j, imageName);
		setChildren(1, rsinterfaceHover);
		setBounds(IMAGEID, 0, 0, 0, rsinterfaceHover);
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean centered) {
		RSInterface rsi = interfaceCache[id] = new RSInterface();
		if (centered)
			rsi.centerText = true;
		rsi.textShadow = true;
		rsi.textDrawingAreas = tda[idx];
		rsi.message = text;
		rsi.textColor = color;
		rsi.id = id;
		rsi.type = 4;
	}

	public static void addText(int id, String text, TextDrawingArea tda[],
			int idx, int color, boolean center, boolean shadow) {
		RSInterface tab = addTabInterface(id);
		tab.parentID = id;
		tab.id = id;
		tab.type = 4;
		tab.atActionType = 0;
		tab.width = 0;
		tab.height = 11;
		tab.contentType = 0;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.centerText = center;
		tab.textShadow = shadow;
		tab.textDrawingAreas = tda[idx];
		tab.message = text;
		tab.aString228 = "";
		tab.textColor = color;
		tab.anInt219 = 0;
		tab.anInt216 = 0;
		tab.anInt239 = 0;
	}

	public String hoverText;
	private int opacity;
	private int hoverType;
	private boolean inventoryHover;

	public static void addHoverBox(int id, String text) {
		RSInterface rsi = interfaceCache[id];// addTabInterface(id);
		rsi.id = id;
		rsi.parentID = id;
		rsi.isMouseoverTriggered = true;
		rsi.type = 8;
		rsi.hoverText = text;
	}

	public static void addButton(int id, int sid, String spriteName,
			String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.tooltip = tooltip;
	}

	public static void addHoverBox(int id, int ParentID, String text,
			String text2, int configId, int configFrame) {
		RSInterface rsi = addTabInterface(id);
		rsi.id = id;
		rsi.parentID = ParentID;
		rsi.type = 8;
		rsi.aString228 = text;
		rsi.message = text2;
		rsi.anIntArray245 = new int[1];
		rsi.anIntArray212 = new int[1];
		rsi.anIntArray245[0] = 1;
		rsi.anIntArray212[0] = configId;
		rsi.valueIndexArray = new int[1][3];
		rsi.valueIndexArray[0][0] = 5;
		rsi.valueIndexArray[0][1] = configFrame;
		rsi.valueIndexArray[0][2] = 0;
	}

	public static void addSprite(int ID, int i, int i2, String name,
			int configId, int configFrame) {
		RSInterface Tab = addTabInterface(ID);
		Tab.id = ID;
		Tab.parentID = ID;
		Tab.type = 5;
		Tab.atActionType = 0;
		Tab.contentType = 0;
		Tab.width = 512;
		Tab.height = 334;
		Tab.aByte254 = (byte) 0;
		Tab.anIntArray245 = new int[1];
		Tab.anIntArray212 = new int[1];
		Tab.anIntArray245[0] = 1;
		Tab.anIntArray212[0] = configId;
		Tab.valueIndexArray = new int[1][3];
		Tab.valueIndexArray[0][0] = 5;
		Tab.valueIndexArray[0][1] = configFrame;
		Tab.valueIndexArray[0][2] = 0;
		Tab.sprite1 = imageLoader(i, name);
		Tab.sprite2 = imageLoader(i2, name);
	}

	public static void addSprite(int id, int spriteId, String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
	}
	
	public static void addHoverButton(int i, String imageName, int j,
			int width, int height, String text, int contentType, int hoverOver,
			int aT) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = aT;
		tab.contentType = contentType;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = hoverOver;
		tab.sprite1 = imageLoader(j, imageName);
		tab.sprite2 = imageLoader(j, imageName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = text;
	}

	public static void addHoveredButton(int i, String imageName, int j, int w,
			int h, int IMAGEID) {// hoverable button
		RSInterface tab = addTabInterface(i);
		tab.parentID = i;
		tab.id = i;
		tab.type = 0;
		tab.atActionType = 0;
		tab.width = w;
		tab.height = h;
		tab.isMouseoverTriggered = true;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = -1;
		tab.scrollMax = 0;
		addHoverImage(IMAGEID, j, j, imageName);
		tab.totalChildren(1);
		tab.child(0, IMAGEID, 0, 0);
	}

	public static void addHoverImage(int i, int j, int k, String name) {
		RSInterface tab = addTabInterface(i);
		tab.id = i;
		tab.parentID = i;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(j, name);
		tab.sprite2 = imageLoader(k, name);
	}

	public static void addTransparentSprite(int id, int spriteId,
			String spriteName) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 52;
		tab.sprite1 = imageLoader(spriteId, spriteName);
		tab.sprite2 = imageLoader(spriteId, spriteName);
		tab.width = 512;
		tab.height = 334;
		tab.drawsTransparent = true;
	}

	public static RSInterface addScreenInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 0;
		tab.atActionType = 0;
		tab.contentType = 0;
		tab.width = 512;
		tab.height = 334;
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = 0;
		return tab;
	}

	public static RSInterface addTabInterface(int id) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;// 250
		tab.parentID = id;// 236
		tab.type = 0;// 262
		tab.atActionType = 0;// 217
		tab.contentType = 0;
		tab.width = 512;// 220
		tab.height = 700;// 267
		tab.aByte254 = (byte) 0;
		tab.mOverInterToTrigger = -1;// Int 230
		return tab;
	}

	protected static Sprite imageLoader(int i, String s) {
		//System.out.println(s);
		if (s == null)
			System.out.println("Null");
		long l = (TextClass.method585(s) << 8) + i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(s + " " + i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception exception) {
			return null;
		}
		return sprite;
	}

	public void child(int id, int interID, int x, int y) {
		children[id] = interID;
		childX[id] = x;
		childY[id] = y;
	}

	public void totalChildren(int t) {
		children = new int[t];
		childX = new int[t];
		childY = new int[t];
	}

	private Model method206(int i, int j) {
		Model model = (Model) aMRUNodes_264.insertFromCache((i << 16) + j);
		if (model != null)
			return model;
		if (i == 1)
			model = Model.method462(j);
		if (i == 2)
			model = EntityDef.forID(j).method160();
		if (i == 3)
			model = Client.myPlayer.method453();
		if (i == 4)
			model = ItemDef.forID(j).method202(50);
		if (i == 5)
			model = null;
		if (model != null)
			aMRUNodes_264.removeFromCache(model, (i << 16) + j);
		return model;
	}

	private static Sprite method207(int i, StreamLoader streamLoader, String s) {
		long l = (TextClass.method585(s) << 8) + i;
		Sprite sprite = (Sprite) aMRUNodes_238.insertFromCache(l);
		if (sprite != null)
			return sprite;
		try {
			sprite = new Sprite(streamLoader, s, i);
			aMRUNodes_238.removeFromCache(sprite, l);
		} catch (Exception _ex) {
			return null;
		}
		return sprite;
	}

	public static void method208(boolean flag, Model model) {
		int i = 0;// was parameter
		int j = 5;// was parameter
		if (flag)
			return;
		aMRUNodes_264.unlinkAll();
		if (model != null && j != 4)
			aMRUNodes_264.removeFromCache(model, (j << 16) + i);
	}

	public Model method209(int j, int k, boolean flag) {
		Model model;
		if (flag)
			model = method206(anInt255, anInt256);
		else
			model = method206(anInt233, mediaID);
		if (model == null)
			return null;
		if (k == -1 && j == -1 && model.anIntArray1640 == null)
			return model;
		Model model_1 = new Model(true, Class36.method532(k)
				& Class36.method532(j), false, model);
		if (k != -1 || j != -1)
			model_1.method469();
		if (k != -1)
			model_1.method470(k);
		if (j != -1)
			model_1.method470(j);
		model_1.method479(64, 768, -50, -10, -50, true);
		return model_1;
	}

	public static void AddInterfaceButton(int id, int sid, String spriteName,
			String tooltip, int mOver, int atAction, int width, int height) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = atAction;
		tab.contentType = 0;
		tab.opacity = 0;
		tab.hoverType = mOver;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = width;
		tab.height = height;
		tab.tooltip = tooltip;
		tab.inventoryHover = true;
	}

	public RSInterface() {
		itemSpriteId1 = -1;
        itemSpriteId2 = -1;
        itemSpriteZoom1 = -1;
        itemSpriteZoom2 = -1;
        itemSpriteIndex = 0;
	}
	private static int[] summoningLevelRequirements = {
		1,4,10,13,16,17,18,19,22,23,25,28,29,31,32,33,34,34,34,34,36,40,41,42,43,43,43,43,43,43,43,46,46,47,49,52,54,55,56,56,57,
		57,57,58,61,62,63,64,66,66,67,68,69,70,71,72,73,74,75,76,76,77,78,79,79,79,80,83,83,85,86,88,89,92,93,95,96,99
	};
	 private static int[] pouchItems = {
			12047,//Spirit_wolf_pouch
			12043,//Dreadfowl_pouch
			12059,//Spirit_spider_pouch
			12019,//Thorny_snail_pouch
			12009,//Granite_crab_pouch
			12778,//Spirit_mosquito_pouch
			12049,//Desert_wyrm_pouch
			12055,//Spirit_scorpion_pouch
			12808,//Spirit_tz-kih_pouch
			12067,//Albino_rat_pouch
			12063,//Spirit_kalphite_pouch
			12091,//Compost_mound_pouch
			12800,//Giant_chinchompa_pouch
			12053,//Vampire_bat_pouch
			12065,//Honey_badger_pouch
			12021,//Beaver_pouch
			12818,//Void_ravager_pouch
			12780,//Void_spinner_pouch
			12798,//Void_torcher_pouch
			12814,//Void_shifter_pouch
			12073,//Bronze_minotaur_pouch
			12087,//Bull_ant_pouch
			12071,//Macaw_pouch
			12051,//Evil_turnip_pouch
			12095,//Sp._cockatrice_pouch
			12097,//Sp._guthatrice_pouch
			12099,//Sp._saratrice_pouch
			12101,//Sp._zamatrice_pouch
			12103,//Sp._pengatrice_pouch
			12105,//Sp._coraxatrice_pouch
			12107,//Sp._vulatrice_pouch
			12075,//Iron_minotaur_pouch
			12816,//Pyrelord_pouch
			12041,//Magpie_pouch
			12061,//Bloated_leech_pouch
			12007,//Spirit_terrorbird_pouch
			12035,//Abyssal_parasite_pouch
			12027,//Spirit_jelly_pouch
			12077,//Steel_minotaur_pouch
			12531,//Ibis_pouch
			12810,//Spirit_graahk_pouch
			12812,//Spirit_kyatt_pouch
			12784,//Spirit_larupia_pouch
			12023,//Karam._overlord_pouch
			12085,//Smoke_devil_pouch
			12037,//Abyssal_lurker_pouch
			12015,//Spirit_cobra_pouch
			12045,//Stranger_plant_pouch
			12079,//Mithril_minotaur_pouch
			12123,//Barker_toad_pouch
			12031,//War_tortoise_pouch
			12029,//Bunyip_pouch
			12033,//Fruit_bat_pouch
			12820,//Ravenous_locust_pouch
			12057,//Arctic_bear_pouch
			14623,//Phoenix_pouch
			12792,//Obsidian_golem_pouch
			12069,//Granite_lobster_pouch
			12011,//Praying_mantis_pouch
			12081,//Adamant_minotaur_pouch
			12782,//Forge_regent_pouch
			12794,//Talon_beast_pouch
			12013,//Giant_ent_pouch
			12802,//Fire_titan_pouch
			12804,//Moss_titan_pouch
			12806,//Ice_titan_pouch
			12025,//Hydra_pouch
			12017,//Spirit_dagannoth_pouch
			12788,//Lava_titan_pouch
			12776,//Swamp_titan_pouch
			12083,//Rune_minotaur_pouch
			12039,//Unicorn_stallion_pouch
			12786,//Geyser_titan_pouch
			12089,//Wolpertinger_pouch
			12796,//Abyssal_titan_pouch
			12822,//Iron_titan_pouch
			12093,//Pack_yak_pouch
			12790,//Steel_titan_pouch
		};
		private static int[] scrollItems = {
			12425,//Howl_scroll
			12445,//Dreadfowl_strike_scroll
			12428,//Egg_spawn_scroll
			12459,//Slime_spray_scroll
			12533,//Stony_shell_scroll
			12838,//Pester_scroll
			12460,//Electric_lash_scroll
			12432,//Venom_shot_scroll
			12839,//Fireball_assault_scroll
			12430,//Cheese_feast_scroll
			12446,//Sandstorm_scroll
			12440,//Generate_compost_scroll
			12834,//Explode_scroll
			12447,//Vampire_touch_scroll
			12433,//Insane_ferocity_scroll
			12429,//Multichop_scroll
			12443,//Call_to_arms_scroll
			12443,//Call_to_arms_scroll
			12443,//Call_to_arms_scroll
			12443,//Call_to_arms_scroll
			12461,//Bronze_bull_rush_scroll
			12431,//Unburden_scroll
			12422,//Herbcall_scroll
			12448,//Evil_flames_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12458,//Petrifying_gaze_scroll
			12462,//Iron_bull_rush_scroll
			12829,//Immense_heat_scroll
			12426,//Thieving_fingers_scroll
			12444,//Blood_drain_scroll
			12441,//Tireless_run_scroll
			12454,//Abyssal_drain_scroll
			12453,//Dissolve_scroll,//,//
			12463,//Steel_bull_rush_scroll
			12424,//Fish_rain_scroll
			12835,//Goad_scroll
			12836,//Ambush_scroll
			12840,//Rending_scroll
			12455,//Doomsphere_scroll
			12468,//Dust_cloud_scroll
			12427,//Abyssal_stealth_scroll
			12436,//Oph._incubation_scroll
			12467,//Poisonous_blast_scroll
			12464,//Mith_bull_rush_scroll
			12452,//Toad_bark_scroll
			12439,//Testudo_scroll
			12438,//Swallow_whole_scroll
			12423,//Fruitfall_scroll
			12830,//Famine_scroll
			12451,//Arctic_blast_scroll
			14622,//Rise_from_the_ashes_scroll
			12826,//Volcanic_str._scroll
			12449,//Crushing_claw_scroll
			12450,//Mantis_strike_scroll
			12465,//Addy_bull_rush_scroll
			12841,//Inferno_scroll
			12831,//Deadly_claw_scroll
			12457,//Acorn_missile_scroll
			12824,//Titan's_con._scroll
			12824,//Titan's_con._scroll
			12824,//Titan's_con._scroll
			12442,//Regrowth_scroll
			12456,//Spike_shot_scroll
			12837,//Ebon_thunder_scroll
			12832,//Swamp_plague_scroll
			12466,//Rune_bull_rush_scroll
			12434,//Healing_aura_scroll
			12833,//Boil_scroll
			12437,//Magic_focus_scroll
			12827,//Essence_shipment_scroll
			12828,//Iron_within_scroll
			12435,//Winter_storage_scroll
			12825,//Steel_of_legends_scroll
		};
		private static String[] scrollNames = {
			"Howl",
			"Dreadfowl Strike",
			"Egg Spawn",
			"Slime Spray",
			"Stony Shell",
			"Pester",
			"Electric Lash",
			"Venom Shot",
			"Fireball Assault",
			"Cheese Feast",
			"Sandstorm",
			"Generate Compost",
			"Explode",
			"Vampire Touch",
			"Insane Ferocity",
			"Multichop",
			"Call of Arms",
			"Call of Arms",
			"Call of Arms",
			"Call of Arms",
			"Bronze Bull Rush",
			"Unburden",
			"Herbcall",
			"Evil Flames",
			"Petrifying gaze",
			"Petrifying gaze",
			"Petrifying gaze",
			"Petrifying gaze",
			"Petrifying gaze",
			"Petrifying gaze",
			"Petrifying gaze",
			"Iron Bull Rush",
			"Immense Heat",
			"Thieving Fingers",
			"Blood Drain",
			"Tireless Run",
			"Abyssal Drain",
			"Dissolve",
			"Steel Bull Rush",
			"Fish Rain",
			"Goad",
			"Ambush",
			"Rending",
			"Doomsphere Device",
			"Dust Cloud",
			"Abyssal Stealth",
			"Ophidian Incubation",
			"Poisonous Blast",
			"Mithril Bull Rush",
			"Toad Bark",
			"Testudo",
			"Swallow Whole",
			"Fruitfall",
			"Famine",
			"Arctic Blast",
			"Rise from the Ashes",
			"Volcanic Strength",
			"Crushing Claw",
			"Mantis Strike",
			"Adamant Bull Rush",
			"Inferno",
			"Deadly Claw",
			"Acorn Missile",
			"Titan's Consitution",
			"Titan's Consitution",
			"Titan's Consitution",
			"Regrowth",
			"Spike Shot",
			"Ebon Thunder",
			"Swamp Plague",
			"Rune Bull Rush",
			"Healing Aura",
			"Boil",
			"Magic Focus",
			"Essence Shipment",
			"Iron Within",
			"Winter Storage",
			"Steel of Legends",
		};
		private static String[] pouchNames = {
			"Spirit wolf",
			"Dreadfowl",
			"Spirit spider",
			"Thorny snail",
			"Granite crab",
			"Spirit mosquito",
			"Desert wyrm",
			"Spirit scorpion",
			"Spirit tz-kih",
			"Albino rat",
			"Spirit kalphite",
			"Compost mound",
			"Giant chinchompa",
			"Vampire bat",
			"Honey badger",
			"Beaver",
			"Void ravager",
			"Void spinner",
			"Void torcher",
			"Void shifter",
			"Bronze minotaur",
			"Bull ant",
			"Macaw",
			"Evil turnip",
			"Sp. cockatrice",
			"Sp. guthatrice",
			"Sp. saratrice",
			"Sp. zamatrice",
			"Sp. pengatrice",
			"Sp. coraxatrice",
			"Sp. vulatrice",
			"Iron minotaur",
			"Pyrelord",
			"Magpie",
			"Bloated leech",
			"Spirit terrorbird",
			"Abyssal parasite",
			"Spirit jelly",
			"Steel minotaur",
			"Ibis",
			"Spirit graahk",
			"Spirit kyatt",
			"Spirit larupia",
			"Karam. overlord",
			"Smoke devil",
			"Abyssal lurker",
			"Spirit cobra",
			"Stranger plant",
			"Mithril minotaur",
			"Barker toad",
			"War tortoise",
			"Bunyip",
			"Fruit bat",
			"Ravenous locust",
			"Arctic bear",
			"Phoenix",
			"Obsidian golem",
			"Granite lobster",
			"Praying mantis",
			"Adamant minotaur",
			"Forge regent",
			"Talon beast",
			"Giant ent",
			"Fire titan",
			"Moss titan",
			"Ice titan",
			"Hydra",
			"Spirit dagannoth",
			"Lava titan",
			"Swamp titan",
			"Rune minotaur",
			"Unicorn stallion",
			"Geyser titan",
			"Wolpertinger",
			"Abyssal titan",
			"Iron titan",
			"Pack yak",
			"Steel titan",
		};

	
	public int itemSpriteId1;
	public int itemSpriteId2;
	public int itemSpriteZoom1;
	public int itemSpriteZoom2;
	public int itemSpriteIndex;
	public boolean greyScale;
	public static StreamLoader aClass44;
	public boolean drawsTransparent;
	public Sprite sprite1;
	public int anInt208;
	public Sprite sprites[];
	public static RSInterface interfaceCache[];
	public int anIntArray212[];
	public int contentType;// anInt214
	public int spritesX[];
	public int anInt216;
	public int atActionType;
	public String spellName;
	public int anInt219;
	public int width;
	public String tooltip;
	public static RSFont[] rsFonts;
	public String selectedActionName;
	public boolean centerText;
	public int scrollPosition;
	public String actions[];
	public int valueCompareType[];
	public int requiredValues[];
	public int valueIndexArray[][];
	public boolean aBoolean227;
	public String aString228;
	public int mOverInterToTrigger;
	public int invSpritePadX;
	public int textColor;
	public int anInt233;
	public int mediaID;
	public boolean aBoolean235;
	public int parentID;
	public int spellUsableOn;
	private static MRUNodes aMRUNodes_238;
	public int anInt239;
	public int children[];
	public int childX[];
	public boolean usableItemInterface;
	public TextDrawingArea textDrawingAreas;
	public int invSpritePadY;
	public int anIntArray245[];
	public int anInt246;
	public int spritesY[];
	public String message;
	public boolean isInventoryInterface;
	public int id;
	public int invStackSizes[];
	public int inv[];
	public byte aByte254;
	private int anInt255;
	private int anInt256;
	public int anInt257;
	public int anInt258;
	public boolean aBoolean259;
	public Sprite sprite2;
	public int scrollMax;
	public int type;
	public int anInt263;
	private static final MRUNodes aMRUNodes_264 = new MRUNodes(30);
	public int anInt265;
	public boolean isMouseoverTriggered;
	public int height;
	public boolean textShadow;
	public int modelZoom;
	public int modelRotation1;
	public int modelRotation2;
	public int childY[];
	public boolean inventoryhover;

	public static void AddInterfaceButton(int id, int sid, String spriteName,
			String tooltip) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.hoverType = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = tab.sprite1.myWidth;
		tab.height = tab.sprite2.myHeight;
		tab.tooltip = tooltip;
	}

	public static void AddInterfaceButton(int i, int j, String name, int W,
			int H, String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = AT;
		RSInterface.contentType = 0;
		RSInterface.opacity = 0;
		RSInterface.hoverType = 52;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.sprite2 = imageLoader(j, name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	public static void AddInterfaceButton(int id, int sid, String spriteName,
			String tooltip, int w, int h) {
		RSInterface tab = interfaceCache[id] = new RSInterface();
		tab.id = id;
		tab.parentID = id;
		tab.type = 5;
		tab.atActionType = 1;
		tab.contentType = 0;
		tab.opacity = (byte) 0;
		tab.hoverType = 52;
		tab.sprite1 = imageLoader(sid, spriteName);
		tab.sprite2 = imageLoader(sid, spriteName);
		tab.width = w;
		tab.height = h;
		tab.tooltip = tooltip;
	}

	public static void AddInterfaceButton(int i, int j, int hoverId,
			String name, int W, int H, String S, int AT) {
		RSInterface RSInterface = addInterface(i);
		RSInterface.id = i;
		RSInterface.parentID = i;
		RSInterface.type = 5;
		RSInterface.atActionType = AT;
		RSInterface.opacity = 0;
		RSInterface.hoverType = hoverId;
		RSInterface.sprite1 = imageLoader(j, name);
		RSInterface.sprite2 = imageLoader(j, name);
		RSInterface.width = W;
		RSInterface.height = H;
		RSInterface.tooltip = S;
	}

	private static void AddInterfaceButton(int ID, int type, int hoverID,
			int dS, int eS, String NAME, int W, int H, String text,
			int configFrame, int configId) {
		RSInterface rsinterface = addInterface(ID);
		rsinterface.id = ID;
		rsinterface.parentID = ID;
		rsinterface.type = 5;
		rsinterface.atActionType = type;
		rsinterface.opacity = 0;
		rsinterface.hoverType = hoverID;
		rsinterface.sprite1 = imageLoader(dS, NAME);
		rsinterface.sprite2 = imageLoader(eS, NAME);
		rsinterface.width = W;
		rsinterface.height = H;
		rsinterface.valueCompareType = new int[1];
		rsinterface.requiredValues = new int[1];
		rsinterface.valueCompareType[0] = 1;
		rsinterface.requiredValues[0] = configId;
		rsinterface.valueIndexArray = new int[1][3];
		rsinterface.valueIndexArray[0][0] = 5;
		rsinterface.valueIndexArray[0][1] = configFrame;
		rsinterface.valueIndexArray[0][2] = 0;
		rsinterface.tooltip = text;
	}

}
