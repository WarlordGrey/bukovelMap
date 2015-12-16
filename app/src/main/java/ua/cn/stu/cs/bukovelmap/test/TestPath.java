package ua.cn.stu.cs.bukovelmap.test;

import java.util.LinkedList;
import java.util.List;

import ua.cn.stu.cs.bukovelmap.MapMath;
import ua.cn.stu.cs.bukovelmap.Exceptions.PathNotFoundException;
import ua.cn.stu.cs.bukovelmap.data.NeighborNodeData;
import ua.cn.stu.cs.bukovelmap.data.NodeData;
import ua.cn.stu.cs.bukovelmap.data.Point;
import ua.cn.stu.cs.bukovelmap.data.RoadData;

public class TestPath {
	
	private static NodeData start;
	private static NodeData end;

	public static void main(String[] args) {
		createMap();
		try {
			List<NodeData> path = MapMath.getPath(start, end, RoadData.ROAD_LEVEL_HARD);
			for (NodeData nodeData : path) {
				System.out.println(nodeData);
			}
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void createMap(){
		NodeData first = new NodeData(new Point(48.3727748706549,24.424989223480225));
		NodeData second = new NodeData(new Point(48.37116415066643,24.421277046203613));
		NodeData third = new NodeData(new Point(48.36990974935203,24.41885232925415));
		NodeData fourth = new NodeData(new Point(48.369567634539756,24.41814422607422));
		NodeData fifth = new NodeData(new Point(48.3686553171371,24.417479038238525));
		NodeData sixth = new NodeData(new Point(48.36664531018976,24.41563367843628));
		NodeData seventh = new NodeData(new Point(48.37284614029523,24.416534900665283));
		NodeData eigth = new NodeData(new Point(48.371050115460164,24.413187503814697));
		NodeData ninth = new NodeData(new Point(48.37023760722373,24.411921501159668));
		NodeData tenth = new NodeData(new Point(48.36922551742908,24.41065549850464));
		NodeData eleventh = new NodeData(new Point(48.36878361275942,24.406964778900146));
		NodeData twelfth = new NodeData(new Point(48.368384469761835,24.41314458847046));
		RoadData r12 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						second.getCoords()
				)
		);
		RoadData r21 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						second.getCoords()
				)
		);
		RoadData r17 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						seventh.getCoords()
				)
		);
		RoadData r71 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						seventh.getCoords()
				)
		);
		RoadData r23 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						second.getCoords()
				)
		);
		RoadData r32 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						second.getCoords()
				)
		);
		RoadData r28 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						second.getCoords(),
						eigth.getCoords()
				)
		);
		RoadData r82 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						second.getCoords(),
						eigth.getCoords()
				)
		);
		RoadData r34 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						fourth.getCoords()
				)
		);
		RoadData r43 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						fourth.getCoords()
				)
		);
		RoadData r39 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						ninth.getCoords()
				)
		);
		RoadData r93 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						third.getCoords(),
						ninth.getCoords()
				)
		);
		RoadData r45 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fourth.getCoords(),
						fifth.getCoords()
				)
		);
		RoadData r54 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fourth.getCoords(),
						fifth.getCoords()
				)
		);
		RoadData r410 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						fourth.getCoords(),
						tenth.getCoords()
				)
		);
		RoadData r104 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						fourth.getCoords(),
						tenth.getCoords()
				)
		);
		RoadData r56 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fifth.getCoords(),
						sixth.getCoords()
				)
		);
		RoadData r65 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fifth.getCoords(),
						sixth.getCoords()
				)
		);
		RoadData r512 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fifth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r125 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						fifth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r612 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						sixth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r126 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						sixth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r78 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						seventh.getCoords(),
						eigth.getCoords()
				)
		);
		RoadData r87 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						seventh.getCoords(),
						eigth.getCoords()
				)
		);
		RoadData r89 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						eigth.getCoords(),
						ninth.getCoords()
				)
		);
		RoadData r98 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						eigth.getCoords(),
						ninth.getCoords()
				)
		);
		RoadData r910 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						ninth.getCoords(),
						tenth.getCoords()
				)
		);
		RoadData r109 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_MEDIUM,
				MapMath.getDistanceBetweenTwoPoints(
						ninth.getCoords(),
						tenth.getCoords()
				)
		);
		RoadData r1011 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						eleventh.getCoords()
				)
		);
		RoadData r1110 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						eleventh.getCoords()
				)
		);
		RoadData r1012 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r1210 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						twelfth.getCoords()
				)
		);
		RoadData r110 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						first.getCoords()
				)
		);
		RoadData r101 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						tenth.getCoords(),
						first.getCoords()
				)
		);
		RoadData r16 = new RoadData(
				false,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						sixth.getCoords()
				)
		);
		RoadData r61 = new RoadData(
				true,
				RoadData.ROAD_LEVEL_EASY,
				MapMath.getDistanceBetweenTwoPoints(
						first.getCoords(),
						sixth.getCoords()
				)
		);
		NeighborNodeData n12 = new NeighborNodeData(r12, second);
		NeighborNodeData n21 = new NeighborNodeData(r21, first);
		NeighborNodeData n17 = new NeighborNodeData(r17, seventh);
		NeighborNodeData n71 = new NeighborNodeData(r71, first);
		
		NeighborNodeData n23 = new NeighborNodeData(r23, third);
		NeighborNodeData n32 = new NeighborNodeData(r32, second);
		NeighborNodeData n28 = new NeighborNodeData(r28, eigth);
		NeighborNodeData n82 = new NeighborNodeData(r82, second);
		
		NeighborNodeData n34 = new NeighborNodeData(r34, fourth);
		NeighborNodeData n43 = new NeighborNodeData(r43, third);
		NeighborNodeData n410 = new NeighborNodeData(r410, tenth);
		NeighborNodeData n104 = new NeighborNodeData(r104, fourth);
		
		NeighborNodeData n45 = new NeighborNodeData(r45, fifth);
		NeighborNodeData n54 = new NeighborNodeData(r54, fourth);
		NeighborNodeData n56 = new NeighborNodeData(r56, sixth);
		NeighborNodeData n65 = new NeighborNodeData(r65, fifth);
		
		NeighborNodeData n512 = new NeighborNodeData(r512, twelfth);
		NeighborNodeData n125 = new NeighborNodeData(r125, fifth);
		NeighborNodeData n612 = new NeighborNodeData(r612, twelfth);
		NeighborNodeData n126 = new NeighborNodeData(r126, sixth);
		
		NeighborNodeData n78 = new NeighborNodeData(r78, eigth);
		NeighborNodeData n87 = new NeighborNodeData(r87, seventh);
		NeighborNodeData n89 = new NeighborNodeData(r89, ninth);
		NeighborNodeData n98 = new NeighborNodeData(r98, eigth);
		
		NeighborNodeData n1011 = new NeighborNodeData(r1011, eleventh);
		NeighborNodeData n1110 = new NeighborNodeData(r1110, tenth);
		NeighborNodeData n1012 = new NeighborNodeData(r1012, twelfth);
		NeighborNodeData n1210 = new NeighborNodeData(r1210, tenth);
		
		NeighborNodeData n101 = new NeighborNodeData(r101, first);
		NeighborNodeData n110 = new NeighborNodeData(r110, tenth);
		NeighborNodeData n16 = new NeighborNodeData(r16, sixth);
		NeighborNodeData n61 = new NeighborNodeData(r61, first);	
		
		NeighborNodeData n39 = new NeighborNodeData(r39, ninth);
		NeighborNodeData n93 = new NeighborNodeData(r93, third);
		NeighborNodeData n109 = new NeighborNodeData(r109, ninth);
		NeighborNodeData n910 = new NeighborNodeData(r910, tenth);
		
		List<NeighborNodeData> n1 = new LinkedList<NeighborNodeData>();
		n1.add(n16);
		n1.add(n12);
		n1.add(n17);
		n1.add(n110);
		
		List<NeighborNodeData> n2 = new LinkedList<NeighborNodeData>();
		n2.add(n21);
		n2.add(n28);
		n2.add(n23);
		
		List<NeighborNodeData> n3 = new LinkedList<NeighborNodeData>();
		n3.add(n32);
		n3.add(n34);
		n3.add(n39);
		
		List<NeighborNodeData> n4 = new LinkedList<NeighborNodeData>();
		n4.add(n43);
		n4.add(n410);
		n4.add(n45);

		List<NeighborNodeData> n5 = new LinkedList<NeighborNodeData>();
		n5.add(n56);
		n5.add(n512);
		n5.add(n54);
		
		List<NeighborNodeData> n6 = new LinkedList<NeighborNodeData>();
		n6.add(n65);
		n6.add(n612);
		n6.add(n61);
		
		List<NeighborNodeData> n7 = new LinkedList<NeighborNodeData>();
		n7.add(n71);
		n7.add(n78);
		
		List<NeighborNodeData> n8 = new LinkedList<NeighborNodeData>();
		n8.add(n82);
		n8.add(n87);
		n8.add(n89);
		
		List<NeighborNodeData> n9 = new LinkedList<NeighborNodeData>();
		n9.add(n98);
		n9.add(n93);
		n9.add(n910);
		
		List<NeighborNodeData> n10 = new LinkedList<NeighborNodeData>();
		n10.add(n101);
		n10.add(n109);
		n10.add(n1011);
		n10.add(n104);
		n10.add(n1012);

		List<NeighborNodeData> n11 = new LinkedList<NeighborNodeData>();
		n11.add(n1110);
		
		List<NeighborNodeData> ne12 = new LinkedList<NeighborNodeData>();
		ne12.add(n1210);
		ne12.add(n125);
		ne12.add(n126);
		
		first.setNeighbors(n1);
		second.setNeighbors(n2);
		third.setNeighbors(n3);
		fourth.setNeighbors(n4);
		fifth.setNeighbors(n5);
		sixth.setNeighbors(n6);
		seventh.setNeighbors(n7);
		eigth.setNeighbors(n8);
		ninth.setNeighbors(n9);
		tenth.setNeighbors(n10);
		eleventh.setNeighbors(n11);
		twelfth.setNeighbors(ne12);
		
		
		start = fifth;
		end = ninth;
		
//		System.out.println("road r12 = " + r12);
//		System.out.println("road r21 = " + r21);
//		System.out.println("road r17 = " + r17);
//		System.out.println("road r71 = " + r71);
//		
//		System.out.println("road r23 = " + r23);
//		System.out.println("road r32 = " + r32);
//		System.out.println("road r28 = " + r28);
//		System.out.println("road r82 = " + r82);
//		
//		System.out.println("road r34 = " + r34);
//		System.out.println("road r43 = " + r43);
//		System.out.println("road r39 = " + r39);
//		System.out.println("road r93 = " + r93);
//		
//		System.out.println("road r45 = " + r45);
//		System.out.println("road r54 = " + r54);
//		System.out.println("road r410 = " + r410);
//		System.out.println("road r104 = " + r104);
//
//		System.out.println("road r56 = " + r56);
//		System.out.println("road r65 = " + r65);
//		System.out.println("road r512 = " + r512);
//		System.out.println("road r125 = " + r125);
//		
//		System.out.println("road r612 = " + r612);
//		System.out.println("road r126 = " + r126);
//		System.out.println("road r1012 = " + r1012);
//		System.out.println("road r1210 = " + r1210);
//		System.out.println("road r1011 = " + r1011);
//		System.out.println("road r1110 = " + r1110);
//		System.out.println("road r78 = " + r78);
//		System.out.println("road r87 = " + r87);
//		
//		System.out.println("road r89 = " + r89);
//		System.out.println("road r98 = " + r98);
//		System.out.println("road r109 = " + r109);
//		System.out.println("road r910 = " + r910);
//
//		System.out.println("road r101 = " + r101);
//		System.out.println("road r110 = " + r110);
//		System.out.println("road r16 = " + r16);
//		System.out.println("road r61 = " + r61);
//		
//		System.out.println("road r12 = " + r12);
//		System.out.println("road r12 = " + r12);
//		System.out.println("road r12 = " + r12);
//		System.out.println("road r12 = " + r12);
		
	}

}
