position = "Protruded Cylinder Hole";
diameter =0.0;
x=0.0;
y=0.0;
lin=0.0;
lout=0.0;
angle=0.0;
module hole(){
difference(){
import("contractureA.stl");
cylinder(lin,diameter/2,diameter/2);
}}
module recHole(){
difference(){
import("contractureA.stl");
translate([-x/2,-y/2,0]) cube([x,y,lin]);
}}
module cutB(){
difference(){
import("contractureB.stl");
translate([0,0,-200-lout]) cylinder(200,200,200);
}}
module straightCyl(){
difference(){
cutB(lout);
translate([0,0,-lout]) cylinder(lout+lin,diameter,diameter);
}}
module straightRec(){
difference(){
cutB(lout);
translate([-x/2,-y/2,-lout]) cube([x,y,lin+lout]);
}}
module barrelC(){
difference(){
cylinder(lout,4+diameter/2,4+diameter/2);
cylinder(lout,diameter/2,diameter/2);
}}
module angledC(){
union(){
import("contractureA.stl");
mirror([0,0,1]) translate([0,0,-diameter*sin(angle)]) rotate([0,angle,0]) barrelC(lout,diameter);
}}
module barrelR(){
difference(){
cylinder(lout,10,10);
translate([-x/2,-y/2,0]) cube([x,y,lout]);
}}
module angledR(){
union(){
import("contractureA.stl");
mirror([0,0,1]) translate([0,0,-10*sin(angle)]) rotate([0,angle,0]) barrelR(lout,x,y);
}}
hole();
