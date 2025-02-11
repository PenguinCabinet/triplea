## Creating Custom Maps

<hr>
<h4><a id="sec_5.1.8">5.1.8</a> Making a Map</h4>
<p>
	This section will go through all the steps needed to be taken in order
	to create a custom map. Before we go any further, lets take the time to explain
	how the &quot;finalized map directory&quot; works and what this document
	means by it.
</p>
<p>
	TripleA has a special directory where it stores its maps and their respective
	configuration files. It is that directory that we refer to as the &quot;finalized
	map directory&quot;. The directory itself has some special conditions that needs
	to be met:
</p>
<ol>
	<li>Located in triplea_0_6_0_1/maps<br></li>
	<li>Name of the map directory must be same as the &quot;mapName&quot; field in the
	XML game file for that game. For example; revised.xml has the mapName
	field showing a value of <b>revised</b> thus the folder where TripleA will find
	the map is also <b>revised</b><br></li>
	<li>All of the following map configuration files must be located inside the directory:
		<ul>
			<li>centers.txt</li>
			<li>polygons.txt</li>
			<li>place.txt</li>
			<li>map.properties</li>
			<li>capitols.txt (optional for victory capitols)</li>
			<li>vc.txt (optional for victory markers)</li>
			<li>pu_place.txt(optional, if it exists this is where PU markers will be placed)</li>
		</ul>
		<br>
	</li>
	<li>A folder named <b>baseTiles</b> with the broken up 256x256 tile images<br></li>
	<li>A folder name <b>reliefTiles</b> (optional if there is a relief map)<br></li>
	<li>The <b>smallMap.jpeg</b> image of the larger original map used</li>
</ol>
<p>
	Let us assume that a custom map we want to make will be called <b>viper</b>. Let us
	also assume that we have a nice large image of our map with black borders separating
	the territories. Our image can either be a GIF or PNG image.<br>
	<br>
	These are the steps we would take to integrate it into TripleA.
</p>
<table class="table1">
	<tr>
		<td><b>Step</b></td>
		<td><b>User Action</b></td>
	</tr>
	<tr>
		<td><b>1</b></td>
		<td>Go into directory: triplea_0_6_0_1/maps</td>
	</tr>
	<tr>
		<td><b>2</b></td>
		<td>Create new directory called <b>viper</b></td>
	</tr>
	<tr>
		<td><b>3</b></td>
		<td>Go back to the base of <b>classes</b>Save the center points in our <b>viper</b> directory we made in Step No. 1</td>
	</tr>
	<tr>
		<td ><b>4</b></td>
		<td>Run the PolygonGrabber and save the polygons file in our <b>viper</b> directory we made in Step No. 1</td>
	</tr>
	<tr>
		<td><b>5</b></td>
		<td>
			Run the PlacementPicker and save the place.txt file in our <b>viper</b> directory.<br>
			<br>
			OR<br>
			<br>
			Create an empty place.txt file in the <b>viper</b> directory and then run AutoPlacementFinder
			Enter &quot;viper&quot; when asked for a map name.
		</td>
	</tr>
	<tr>
		<td><b>6</b></td>
		<td>Run the TileImageBreaker and save all the tiles in <b>baseTiles</b> inside <b>viper</b></td>
	</tr>
	<tr>
		<td><b>7</b></td>
		<td>
			If we have a relief map, then run the ReliefImageBreaker and save all the tiles in
			<b>reliefTiles</b> inside <b>viper</b>; say &quot;N&quot; to do Only Sea Zones
		</td>
	</tr>
	<tr>
		<td><b>8</b></td>
		<td>Run the ImageShrinker and copy the <b>smallMap.jpeg</b> to the <b>viper</b> directory</td>
	</tr>
	<tr>
		<td><b>9</b></td>
		<td>
			Create a <b>map.properties</b> file with map properties
			See <a href="#sec_5.2">Section 5.2</a> for more information
		</td>
	</tr>
	<tr>
		<td><b>10</b></td>
		<td>
			Make sure our XML game file shows <b>viper</b> as the value
			for the &quot;mapName&quot; property option
		</td>
	</tr>
	<tr>
		<td><b>11</b></td>
		<td>All Done !</td>
	</tr>
</table>
<h2><a id="sec_5.2">5.2</a> Map Configuration</h2>
<p>
	Each map has its own configuration options. These are found in the map's directory
	where there tile images and centers, polygons, and place text files are. These map
	options can be configured at any time and does not require that TripleA be re-compiled
	for the settings to take effect.
</p>
<p>
	This section and the following sub-sections will cover the following:
</p>
<ul>
	<li>Changing territory colors</li>
	<li>Pre-set releif map settings</li>
	<li>Pre-set unit scales</li>
	<li>Scroll Locking</li>
	<li>Capital marker toggles</li>
	<li>Victory Cities</li>
	<li>Capital Cities</li>
	<li>Victory Markers</li>
</ul>
<h4><a id="sec_5.2.1">5.2.1</a> Map Properties</h4>
<p>
	Specific map properties are found in a file named <b>map.properties</b>. This
	file can be editted at will by the user. It allows for the following changes:
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>color.Americans=</td>
		<td>HEX Number Color</td>
		<td>Color of all American Territories</td>
	</tr>
	<tr>
		<td>units.scale=</td>
		<td>
			Floating Point; One of :<br>
			<ul>
				<li>1.25</li>
				<li>1.00</li>
				<li>0.875</li>
				<li>0.8333</li>
				<li>0.75</li>
				<li>0.6666</li>
				<li>0.5625</li>
				<li>0.50</li>
			</ul>
		</td>
		<td>Starting scale size of image units</td>
	</tr>
	<tr>
		<td>map.hasRelief=</td>
		<td>Boolean</td>
		<td>Sets relief images on or off by default</td>
	</tr>
	<tr>
		<td>map.showCapitolMarkers</td>
		<td>Boolean</td>
		<td>Display capital markers images</td>
	</tr>
	<tr>
		<td>map.scrollWrapX=</td>
		<td>Boolean</td>
		<td>Lock X-Axis scrolling</td>
	</tr>
	<tr>
		<td>map.width=</td>
		<td>Non-Zero Integer</td>
		<td>Width of map image</td>
	</tr>
	<tr>
		<td>map.height=</td>
		<td>Non-Zero Integer</td>
		<td>Height of map image</td>
	</tr>
	<tr>
		<td>#</td>
		<td>Any Printable Character</td>
		<td>In file comments, these get ignored by TripleA</td>
	</tr>
</table>
<br>
<p>
	For completeness, below is an example of a <b>map.properties</b> file. This way
	we can see how the above options and values are used in a practical setting.
</p>
<br>
<br>
<table class="thickTable">
	<tr>
		<td><b>Example of A map.properties File</b></td>
	</tr>
	<tr>
		<td><pre><code>#Color settings for the map<br>#values must be a 6 digit hex number<br>color.British=996600<br>color.Americans=666600<br>color.Russians=993300<br>color.Germans=777777<br>color.Japanese=FF9900<br>color.Italians=5A5A5A<br>color.Neutral=dd5500<br>color.Impassible=cc9933<br>color.Chinese=442244<br><br>#default unit scale<br>#value must be one of the menu options<br>units.scale=0.5625<br><br>#does the map have relief images<br>map.hasRelief=false<br><br>#show capitol markers<br>map.showCapitolMarkers=false<br><br>map.width=4000<br>map.height=2000<br><br>#lock horizontal scrolling<br>map.scrollWrapX=false<br></code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.2.2">5.2.2</a> Capital Cities</h4>
<p>
	TripleA is also able to mark certain territories as capitals. Along with
	that, TripleA can draw an image on the territory to mark it as a capital.
	These images are called &quot;Captial Markers&quot;.
</p>
<p>
	The default TripleA capital markers can be found in the directory listed
	below; note that capital markers end with the word &quot;large&quot;:<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>Location of Capital Markers</b></td>
	</tr>
	<tr>
		<td><pre><code>triplea_0_6_0_1/images/flags<br></code></pre></td>
	</tr>
</table>
<br>
<p>
	If you want to add custom capitol markers to your game (or override the defaults), add a
	put your flags in maps/mapName/images/flags/
</p>
<p>
	Below is a list of TripleA's captial markers that are used for World War II
	games and other variants:<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td colspan="6"><b>TripleA Capital Markers</b></td>
	</tr>
	<tr>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297110/73e54abc-c52e-11e6-8e18-0bf4e95cc24c.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297107/73e0f7a0-c52e-11e6-8c25-c6ad3cc6a8b2.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297109/73e1561e-c52e-11e6-8f23-d7624ee2e7a4.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297106/73e0ebc0-c52e-11e6-82bc-3872d8847b88.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297114/73f616c6-c52e-11e6-9d68-0a280ae95245.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297113/73f3035a-c52e-11e6-8054-5d64cf165b8b.png" width="100" height="100" alt=""></td>
	</tr>
	<tr>
		<td>U.S.A</td>
		<td>Australia</td>
		<td>U.K</td>
		<td>China</td>
		<td>E.U</td>
		<td>Germany</td>
	</tr>
	<tr>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297112/73f2dfce-c52e-11e6-993f-49c284686c21.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297115/73f664fa-c52e-11e6-8746-d7b227a16968.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297116/73f6bdba-c52e-11e6-8600-e020ef26c59f.png" width="98" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297119/74079d10-c52e-11e6-845f-0de5d6934694.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297123/7418a5ce-c52e-11e6-850d-8e65b2353c5d.png" width="100" height="100" alt=""></td>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297127/741bec7a-c52e-11e6-8780-54691e72d99d.png" width="100" height="100" alt=""></td>
	</tr>
	<tr>
		<td>Italy</td>
		<td>Japan</td>
		<td>Mid-East</td>
		<td>China</td>
		<td>U.S.S.R</td>
		<td>U.K Union Jack</td>
	</tr>
</table>
<br>
<p>
	Capital cities can be added in a game's XML file. An extra option has to be
	added to a territory attachment tag.<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>Capital XML Option</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;option id="capital" value="Germans"/&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	A full example of a territory attachment with the capital option:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Capital XML Option</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;attachment id="territoryAttachment" attachTo="Germany" javaClass="games.strategy.triplea.attachments.TerritoryAttachment" type="territory"&gt;
         &lt;option id="production" value="10"/&gt;
         &lt;option id="capital" value="Germans"/&gt;
&lt;/attachment&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	For TripleA to draw capital markers more appropriately, it uses a <b>capitols.txt</b>
	file located in the maps directory. This file lists all the capitals and
	the starting (X,Y) coordinates from where to draw the capital markers. If this file
	is missing, then TripleA will use a default location on where to draw the images.
</p>
<p>
	An example of a <b>capitols.txt</b> file is listed below. Note that the names
	of the territories need to match the names in the other text files (centers, place, polygons).<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Capitols.txt File Example</b></td>
	</tr>
	<tr>
		<td><pre><code>United Kingdom (709,292)<br>Germany (981, 532)<br>Russia (1723,337)<br>Japan (2711,686)<br>Eastern United States (33,616)</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.2.3">5.2.3</a> Victory Cities</h4>
<p>
	TripleA has the ability to keep track of territories that are considered
	to be an objective to capture and hold; otherwise known as &quot;victory cities&quot;.
	The owner of these territories are tracked and displayed in TripleA's stats
	window.
</p>
<p>
	Victory Cities, just like capitals, have their own image markers as well.
	TripleA comes with a very simple victory marker which can be replaced by
	the user at any time. The victory marker can be found below:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Capital XML Option</b></td>
	</tr>
	<tr>
		<td><pre><code>triplea_0_6_0_1/images/vc.png</code></pre></td>
	</tr>
</table>
<br>
<table class="thinTable">
	<tr>
		<td><b>TripleA's Default VC Image</b></td>
	</tr>
	<tr>
		<td><img src="https://cloud.githubusercontent.com/assets/12397753/21297128/741c18d0-c52e-11e6-887a-3c6afd6d2505.png" width="22" height="18" alt="vc image"></td>
	</tr>
</table>
<br>
<p>
	Victory cities can be added in a game's XML file. An extra option has to be
	added to a territory attachment tag.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Victory City XML Option</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;option id="victoryCity" value="true"/&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	A full example of a territory attachment with the capital option:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Victory City XML Option</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;attachment id="territoryAttachment" attachTo="Karelia" javaClass="games.strategy.triplea.attachments.TerritoryAttachment" type="territory"&gt;<br>&nbsp;&lt;option id="production" value="10"/&gt;<br>&nbsp;&lt;option id="victoryCity" value="true"/&gt;<br>&lt;/attachment&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	Capitals can also be victory cities.
</p>
<p>
	For TripleA to draw victory city markers more appropriately, it uses a <b>vc.txt</b>
	file located in the maps directory. This file lists all the victory cities and
	the starting (X,Y) coordinates from where to draw the victory markers. If this file
	is missing, then TripleA will use a default location on where to draw the images.
</p>
<p>
	An example of a <b>vc.txt</b> file is listed below. Note that the names
	of the territories need to match the names in the other text files (centers, place, polygons).<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>vc.txt File Example</b></td>
	</tr>
	<tr>
		<td><pre><code>Karelia S.S.R. (1243,276)<br>Russia (1863,214)<br>Western Europe (807,527)<br>Germany (1090,518)<br>Southern Europe (980,880)<br>United Kingdom (760,390)<br>Eastern United States (205,630)<br>Western United States (3343,735)<br>Philipine Islands (2435,1250)<br>India (1939,997)<br>Japan (2680,750)<br>Kwangtung (2427, 790)</code></pre></td>
	</tr>
</table>
<h2><a id="sec_5.3">5.3</a> Customizing The XML Game File</h2>
<p>
	XML files are used to set-up and initialize games in TripleA. These XML files are
	found in the <b>games</b> directory in the root of TripleA. They can edited and
	used to create new kinds of games or variants of existing games. XML files can
	usually be edited by using any simple text editor, though it may be wise to use
	some sort of special editor that can color code the XML. It makes it easier to
	edit.
</p>
<p>
	The sections below will mainly go over how to edit and change values in some
	of the XML game files that come with TripleA. TripleA currently has game logic
	code for use with standard war games, so the following sections shall use
	those as examples.
</p>
<h4><a id="sec_5.3.1">5.3.1</a> Game Information Header</h4>
<p>
	Every game that comes with TripleA normally has four XML tags that gives
	us some information about it.
</p>
<ul>
	<li>XML Version</li>
	<li>XML Game Sheet Definition</li>
	<li>Name and Version of Game</li>
	<li>Java Class Loader</li>
</ul>
<p>
	At the top of every XML file it must include a tag specifying what
	version of XML is being used.<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>XML Version</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;?xml version="1.0" ?&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	The game definition sheet must always be specified. In the example below
	we use the &quot;game.dtd&quot; definition. It can be located in the
	<i>triplea_0_6_0_1/data/games/strategy/engine/xml</i> directory.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Definition Sheet</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;!DOCTYPE game SYSTEM "game.dtd"&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	The &quot;info&quot; tag contains the game name and version number. This normally
	can be edited by any one and will not affect the game much. It is just for display
	on the main TripleA window when the game is loaded.<br>
	<br>
	The &quot;loader&quot; tag defines what class file is used to load this game. As we
	can see below; the class used to load this World War II type game is a class
	called <b>TripleA.class</b> but we do not include the &quot;.class&quot; but we do
	include the full package path.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Info &amp; Loader Tags</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;info id="4th Edition" version="1.2"/&gt;<br>&lt;loader javaClass="games.strategy.triplea.TripleA"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.2">5.3.2</a> Territories</h4>
<p>
	Territory definitions occur in the <b>map</b> tags along with their
	respective connections. Territories can be added or removed by editing
	these territory tags. These tags come with two values &quot;Name&quot;
	and &quot;water&quot;
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the territory</td>
	</tr>
	<tr>
		<td>water="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>True if this territory is a sea zone</td>
	</tr>
</table>
<br>
<p>
	Two qualified examples:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Territory Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;territory id="Argentina"/&gt;</code></pre></td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Territory Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;territory id="Atlantic Ocean" water="true"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.3">5.3.3</a> Territory Connections</h4>
<p>
	Each territory must have some kind of relation to the territory
	next to it. When two territories are connected together, that means
	that a movement action can occur between those two territories. These
	connections are defined using <b>connection</b> tags located inside
	the <b>map</b> tag where you also find <b>territory</b> tags.
</p>
<p>
	A connection tag consists of only two options; source and destination.
	When a connection tag is made, there is no need to do the same connection
	in reverse. When territory A is connected to territory B, this also implies
	that territory B is connected to territory A.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>t1="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the source</td>
	</tr>
	<tr>
		<td>t2="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the destination</td>
	</tr>
</table>
<table class="thickTable">
	<tr>
		<td><b>Resource Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;connection t1="Venezuala" t2="Brazil"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.4">5.3.4</a> Resources</h4>
<p>
	The resources for the game needs to have some sort of name. Maybe it is Dollars,
	or maybe it is gold bars. Either way modifying this is very simple. We change the
	the name option of the <b>resource</b> tag which is enclosed between a
	<b>resourceList</b> tag.
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the resource</td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Resource Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;resourceList&gt;<br>&nbsp;&lt;resource id="PUs"/&gt;<br>&lt;/resourceList&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.5">5.3.5</a> Players &amp; Alliances</h4>
<p>
	Players and alliances can be defined using the <b>player</b> and
	<b>alliance</b> tags which are to be enclosed inside the <b>playerList</b>
	tag. Defining player names and alliance are pretty straight forward.
</p>
<p>
	Player tag options and values<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the player</td>
	</tr>
	<tr>
		<td>optional="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Is this player mandatory</td>
	</tr>
</table>
<br>
Alliance tag options and values<br>
<br>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>player="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the player</td>
	</tr>
	<tr>
		<td>alliance="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the alliance</td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Player &amp; Alliance Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;playerList&gt;
  &lt;player id="Japanese" optional="false"/&gt;
  &lt;player id="Germans" optional="false"/&gt;
  &lt;player id="British" optional="false"/&gt;
  &lt;player id="Americans" optional="false"/&gt;
  &lt;player id="Russians" optional="false"/&gt;

  &lt;alliance player="Germans" alliance="Axis"/&gt;
  &lt;alliance player="Japanese" alliance="Axis"/&gt;
  &lt;alliance player="British" alliance="Allies"/&gt;
  &lt;alliance player="Russians" alliance="Allies"/&gt;
  &lt;alliance player="Americans" alliance="Allies"/&gt;
&lt;/playerList></code></pre></td>
	</tr>
</table>
	<h4><a id="sec_5.3.6">5.3.6</a> Units</h4>
		<p>
			Units are defined in <b>unit</b> tags enclosed inside <b>unitList</b> tags.
			These too are simple tags that define the names of units only. The
			properties of units can be modified later on using the <b>attachment</b>
			tags (which will be discussed later in <a href="#sec_5.3.10">Section 5.3.10</a>.
		</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the unit</td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Unit Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;unitList&gt;
   &lt;unit id="infantry"/&gt;
   &lt;unit id="armour"/&gt;
   &lt;unit id="fighter"/&gt;
   &lt;unit id="bomber"/&gt;
   &lt;unit id="transport"/&gt;
   &lt;unit id="battleship"/&gt;
   &lt;unit id="carrier"/&gt;
   &lt;unit id="submarine"/&gt;
   &lt;unit id="factory"/&gt;
   &lt;unit id="aaGun"/&gt;
   &lt;unit id="artillery"/&gt;
   &lt;unit id="destroyer"/&gt;
&lt;/unitList&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.7">5.3.7</a> Game-play Delegates</h4>
	<p>
		<b>Delegate</b> tags are found inside the <b>gamePlay</b> tags (along with other tags).
		What these tags basically do is identify a certain Java class with a delegate name so
		that it can be used later on in other tags. These Java classes are delegates themselves
		that handel game logic. These delegate tags serve as a kind of &quot;macro&quot; that
		binds the Java class with a specified name.
	</p>
	<p>
		For example; all the game logic for conducting battles in a World War II v2 Revised
		game are in the <b>BattleDelegate.java</b> class located in <i>games.strategy.triplea.delegate</i>
		class path. When we want to reference that delegate in the XML we have to make a <b>delegate</b>
		tag and bind it to a name. A name as &quot;battle&quot; would be fine.
		<br>
	</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the delegate</td>
	</tr>
	<tr>
		<td>javaClass="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name and Package location of the delegate class</td>
	</tr>
	<tr>
		<td>display="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>What TripleA will display when the delegate is in use</td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Delegate Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;delegate id="battle" javaClass="games.strategy.triplea.delegate.BattleDelegate" display="Combat"/&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	Of course there will be many delegates that TripleA can use for handeling game logic.
	And thus would need numerous delegate tags defined in the XML to set-up a game properly.
	For the sake of completenes and practicallity, below is an example of all the delegate
	tags used in the World War II v2 Revised XML file:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Delegate Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;delegate id="initDelegate"
      javaClass="games.strategy.triplea.delegate.InitializationDelegate"
      display="Initializing Delegates"/&gt;
&lt;delegate id="tech"
      javaClass="games.strategy.triplea.delegate.TechnologyDelegate"
      display="Research Technology"/&gt;
&lt;delegate id="tech_activation"
      javaClass="games.strategy.triplea.delegate.TechActivationDelegate"
      display="Activate Technology"/&gt;
&lt;delegate id="battle"
      javaClass="games.strategy.triplea.delegate.BattleDelegate"
      display="Combat"/&gt;
&lt;delegate id="move"
      javaClass="games.strategy.triplea.delegate.MoveDelegate"
      display="Combat Move"/&gt;
&lt;delegate id="place"
      javaClass="games.strategy.triplea.delegate.PlaceDelegate"
      display="Place Units"/&gt;
&lt;delegate id="purchase"
      javaClass="games.strategy.triplea.delegate.PurchaseDelegate"
      display="Purchase Units"/&gt;
&lt;delegate id="endTurn"
      javaClass="games.strategy.triplea.delegate.EndTurnDelegate"
      display="Turn Complete"/&gt;
&lt;delegate id="endRound"
      javaClass="games.strategy.triplea.delegate.EndRoundDelegate"
      display="Round Complete"/&gt;
&lt;delegate id="placeBid"
      javaClass="games.strategy.triplea.delegate.BidPlaceDelegate"
      display="Bid Placement"/&gt;
&lt;delegate id="bid"
      javaClass="games.strategy.triplea.delegate.BidPurchaseDelegate"
      display="Bid Purchase"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.8">5.3.8</a> Game-play Sequence &amp; Steps</h4>
<p>
	Every game has a certain repeatable sequence that needs to be followed
	for the game to run properly. Such a sequence needs to be defined in the
	XML file as well. The sequence is broken down in to individual steps, and
	it is these steps that need to be defined. We have several <b>step</b>
	tags encapsulated by one <b>sequence</b> tag. The <b>step</b> tags define
	the sequence of the game.
</p>
<p>
	<b>Step</b> tags are quite versitile and simple to implement. All <b>step</b>
	tags must have a name and must be bound to a delegate. The delegate it is bound
	to is a delegate name that has been predefined in a <b>delegate</b> tag. Then
	after that there are several different options that can be added depending what
	kind of a step is being made. The specifications are listed below as well as a
	few examples.
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the step</td>
	</tr>
	<tr>
		<td>delegate="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Delegate name</td>
	</tr>
	<tr>
		<td>player="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Player name</td>
	</tr>
	<tr>
		<td>maxRunCount="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>Number of times the delegate will run.</td>
	</tr>
	<tr>
		<td>display="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>What TripleA will display when the delegate is in use</td>
	</tr>
</table>
<br>
<p>
	Bid placements can only occur once in this game, so we make bidding happen first
	and limit it to one occurance.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Step Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;step id="russianBid" delegate="bid" player="Russians" maxRunCount="1"/&gt;
&lt;step id="russianBidPlace" delegate="placeBid" player="Russians" maxRunCount="1"/&gt;</code></pre></td>
	</tr>
</table>
<p>
	We define a the full turn sequence of a player through multiple steps:<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Step Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;step id="japaneseTech" delegate="tech" player="Japanese"/&gt;
&lt;step id="japaneseTechActivation" delegate="tech_activation" player="Japanese"/&gt;
&lt;step id="japanesePurchase" delegate="purchase" player="Japanese"/&gt;
&lt;step id="japaneseCombatMove" delegate="move" player="Japanese"/&gt;
&lt;step id="japaneseBattle" delegate="battle" player="Japanese"/&gt;
&lt;step id="japaneseNonCombatMove" delegate="move" player="Japanese" display="Non Combat Move"/&gt;
&lt;step id="japanesePlace" delegate="place" player="Japanese"/&gt;
&lt;step id="japaneseEndTurn" delegate="endTurn" player="Japanese"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.9">5.3.9</a> Production Rules</h4>
<p>
	Production rules define how the game handels the production of units
	and resources. Production rules consist of three main tags which get
	encapsulated inside <b>production</b> tags:
</p>
<ul>
	<li><b>productionRule</b> : Defines the name of the item, its cost, quantity, and result</li>
	<li><b>productionFrontier</b> : Defines a group of production</li>
	<li><b>playerProduction</b> : What players are eligable for production</li>
</ul>
<p>
	A <b>productionRule</b> tag consists of several options and sub-tags that
	will define the production method and cost of an item or unit. Normally a
	production rule has a name that defines what it is producing, such as &quot;buyTanks&quot;.
	Then a <b>cost</b> tag specifies the quantity of resources that is needed to make a
	purchase. Lastly, a <b>result</b> tag is used to explain what the result of the purchase
	will yeild and the quantity.
</p>
<p>
	Options and Values for <b>productionRule</b> tag:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the productionRule</td>
	</tr>
</table>
<br>
Options and Values for <b>cost</b> tag:<br>
<br>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>resource="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the resource</td>
	</tr>
	<tr>
		<td>quantity="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>Amount needed for purchase</td>
	</tr>
</table>
<br>
Options and Values for <b>result</b> tag:<br>
<br>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>resourceOrUnit="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of the resource or unit that is being produced</td>
	</tr>
	<tr>
		<td>quantity="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>Quantity of that product to give out</td>
	</tr>
</table>
<br>
<p>
	A practical example:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Production Rule Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;productionRule id="buyTanks"&gt;
	&lt;cost resource="PUs" quantity="4" /&gt;
	&lt;result resourceOrUnit="armour" quantity="1"/&gt;
&lt;/productionRule&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	A <b>productionFrontier</b> tag groups different types of production rules.
	There can be more than one production frontier. For example in World War II v2 Revised,
	there is regular production of units and production of technologically advanced
	units. Both are in different frontiers beacuse they deal with the same kind of
	units, but with different values. Such as a standard airplane vs a jet powered airplane.
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of production frontier</td>
	</tr>
</table>
<br>
<p>
	<b>frontierRules</b> tags are sub-tags of <b>productionFrontier</b>. These sub-tags define
	what productionRule is grouped with that frontier.<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Name of frontier rule</td>
	</tr>
</table>
<br>
<p>
	A practical example:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Production Frontier Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;productionFrontier id="production"&gt;
&lt;frontierRules id="buyInfantry"/&gt;
    &lt;frontierRules id="buyArtillery"/&gt;
    &lt;frontierRules id="buyArmour"/&gt;
&lt;/productionFrontier&gt;
&lt;productionFrontier id="productionIndustrialTechnology"&gt;
    &lt;frontierRules id="buyInfantryIndustrialTechnology"/&gt;
    &lt;frontierRules id="buyArtilleryIndustrialTechnology"/&gt;
    &lt;frontierRules id="buyArmourIndustrialTechnology"/&gt;
&lt;/productionFrontier&gt;</code></pre></td>
	</tr>
</table>
<br>
<p>
	Last but not least, <b>playerProduction</b> tags specify which players
	are eligable to which production forntier.
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>player="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Player name</td>
	</tr>
	<tr>
		<td>frontier="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>Production frontier name</td>
	</tr>
</table>
<br>
<table class="thickTable">
	<tr>
		<td><b>Player Production Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;playerProduction player="British" frontier="production"/&gt;</code></pre></td>
	</tr>
</table>
<h4><a id="sec_5.3.10">5.3.10</a> Unit Attachment</h4>
<p>
	Unit definition rules are mainly handled in the <b>unitAttachment</b> tag.
	This is the place where we can define what specific options to be &quot;attached&quot;
	to which unit. The tag compositions is relatively quite simple. The header tag defines
	what kind of attachment is to be defined, the name of the item it should be attached to,
	which java class to use, and of what type is it.
</p>
<p>
	Options and Values for <b>attachment</b> tag:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The name of the attachment. This must end with the word &quot;Attachment&quot;</td>
	</tr>
	<tr>
		<td>attachTo="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The name of the item to attach it to</td>
	</tr>
	<tr>
		<td>javaClass="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The java class name and its fully qualified package location</td>
	</tr>
	<tr>
		<td>type="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The type</td>
	</tr>
</table>
<br>
<p>
	Within the <b>attachment</b> tag will be an arbitrary amount of <b>option</b>
	tags which will define the type of properties the attachment will have. It can
	have very few or many. Below is a list of options that can be used:
</p>
<p>
	List of <b>option</b> tags that can be used :<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>movement="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The allowed movement points</td>
	</tr>
	<tr>
		<td>transportCost="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The cost for being loaded onto a transport ship</td>
	</tr>
	<tr>
		<td>carrierCost="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The cost for being loaded onto an air-craft carrier</td>
	</tr>
	<tr>
		<td>transportCapacity="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The maximum number of items a transport ship can load</td>
	</tr>
	<tr>
		<td>carrierCapacity="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The maximum number of items an air-craft carrier can load</td>
	</tr>
	<tr>
		<td>canBlitz="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows a unit to capture an undefended territory while moving on to the next</td>
	</tr>
	<tr>
		<td>canBombard="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows an air unit to have bombardment capabilities</td>
	</tr>
	<tr>
		<td>isAir="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this unit can fly in the air or not</td>
	</tr>
	<tr>
		<td>isSea="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies of this unit can go in water or not</td>
	</tr>
	<tr>
		<td>isFactory="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this unit is a factory</td>
	</tr>
	<tr>
		<td>isDestroyer="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this unit is a destroyer</td>
	</tr>
	<tr>
		<td>isAA="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this unit is an anti-aircraft gun</td>
	</tr>
	<tr>
		<td>isSub="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this is a submersible unit</td>
	</tr>
	<tr>
		<td>isTwoHit="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows a unit to absorb one extra attack hits before being destroyed</td>
	</tr>
	<tr>
		<td>isStrategicBomber="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if an air-craft can perform strategic bombing</td>
	</tr>
	<tr>
		<td>artillerySupportable="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this unit can be supported by artillery or not</td>
	</tr>
	<tr>
		<td>artillery="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Specifies if this is an artillery unit or not</td>
	</tr>
	<tr>
		<td>attack="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The attack value</td>
	</tr>
	<tr>
		<td>defense="&nbsp;&nbsp;&nbsp;"</td>
		<td>Integer</td>
		<td>The defense value</td>
	</tr>
</table>
<br>
<p>
	A practical example:<br>
	<br>
</p>
<table class="thickTable">
	<tr>
		<td><b>Unit Attachment Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;attachment id="unitAttachment" attachTo="battleship" javaClass="games.strategy.triplea.attachments.UnitAttachment" type="unitType"&gt;
	&lt;option id="movement" value="2"/&gt;
	&lt;option id="isSea" value="true"/&gt;
	&lt;option id="attack" value="4"/&gt;
	&lt;option id="defense" value="4"/&gt;
	&lt;option id="canBombard" value="true"/&gt;
	&lt;option id="isTwoHit" value="false"/&gt;
&lt;/attachment&gt;
&lt;attachment id="unitAttachment" attachTo="infantry" javaClass="games.strategy.triplea.attachments.UnitAttachment" type="unitType"&gt;
    &lt;option id="movement" value="1"/&gt;
    &lt;option id="transportCost" value="2"/&gt;
    &lt;option id="attack" value="1"/&gt;
    &lt;option id="defense" value="2"/&gt;
    &lt;option id="artillerySupportable" value="true"/&gt;
&lt;/attachment&gt;
&lt;attachment id="unitAttachment" attachTo="factory" javaClass="games.strategy.triplea.attachments.UnitAttachment" type="unitType"&gt;
    &lt;option id="isFactory" value="true"/&gt;
&lt;/attachment&gt;</code></pre></td>
	</tr>
</table>
<br>
<h4><a id="sec_5.3.11">5.3.11</a> Tech Attachment</h4>
<p>
	Technology definition rules are mainly handled in the <b>techAttachment</b> tag.
	This is the place where we can define what specific types of technological advancements
	are allowed for this particular player. The tag compositions is relatively quite simple.
	The header tag defines what kind of attachment is to be defined, the name of the player
	it should be attached to, which java class to use, and of what type is it.
</p>
<p>
	Options and Values for <b>attachment</b> tag:<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>id="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The name of the attachment. This must end with the word &quot;Attachment&quot;</td>
	</tr>
	<tr>
		<td>attachTo="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The name of the player to attach it to</td>
	</tr>
	<tr>
		<td>javaClass="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The java class name and its fully qualified package location</td>
	</tr>
	<tr>
		<td>type="&nbsp;&nbsp;&nbsp;"</td>
		<td>String</td>
		<td>The type</td>
	</tr>
</table>
<br>
<p>
	Within the <b>attachment</b> tag will be an arbitrary amount of <b>option</b>
	tags which will define the type of properties the attachment will have. It can
	have very few or many. Below is a list of options that can be used:
</p>
<p>
	List of <b>option</b> tags that can be used :<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>Option</b></td>
		<td><b>Value</b></td>
		<td><b>Description</b></td>
	</tr>
	<tr>
		<td>heavyBomber="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire heavy bombers</td>
	</tr>
	<tr>
		<td>jetPower="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire jet propulsion technology</td>
	</tr>
	<tr>
		<td>industrialTechnology="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire industrial technology</td>
	</tr>
	<tr>
		<td>superSubs="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire advanced submarine units</td>
	</tr>
	<tr>
		<td>rocket="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire rocket technology</td>
	</tr>
	<tr>
		<td>longRangeAir="&nbsp;&nbsp;&nbsp;"</td>
		<td>Boolean</td>
		<td>Allows for a player to acquire long range air units</td>
	</tr>
</table>
<br>
<p>
	These options can all be initialized to &quot;false&quot; unless we want
	a player to start off with a technology advancement.
</p>
<p>
	A practical example:<br>
</p>
<br>
<table class="thickTable">
	<tr>
		<td><b>Tech Attachment Example</b></td>
	</tr>
	<tr>
		<td><pre><code>&lt;attachment id="techAttachment" attachTo="British" javaClass="games.strategy.triplea.attachments.TechAttachment" type="player"&gt;
	&lt;option id="heavyBomber" value="false"/&gt;
	&lt;option id="jetPower" value="false"/&gt;
	&lt;option id="industrialTechnology" value="false"/&gt;
	&lt;option id="superSub" value="false"/&gt;
	&lt;option id="rocket" value="false"/&gt;
	&lt;option id="longRangeAir" value="false"/&gt;
&lt;/attachment&gt;</code></pre></td>
	</tr>
</table>
<br>
<h4><a id="sec_6.5">6.5</a> Game Play Sequence</h4>
<p>
 The game sequence is definied in the XML file (game-gamePlay-sequence). Each step entry defined here
 basically creates a <a href="#sec_6.6">delegate</a> for a certain player which then handles the current step.
 The end of a round is defined by a step for the endRound delegate and leads to a loop back to the first step.
</p>
<h4><a id="sec_6.6">6.6</a> Delegates</h4>
<p>
  Delegates are the class which are responsible for a certain game step. They are supposed to be the only
  place where game data is actually changed.
</p>

