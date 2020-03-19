extends Area2D


const DEFAULT_SPEED = 200
var _direction = Vector2.LEFT #(x, y) (-1, 0) => (0.70, .27)

# Called when the node enters the scene tree for the first time.
func _ready():
	pass

# Called every frame. 'delta' is the elapsed time since the previous frame.
func _process(delta):
	position += (DEFAULT_SPEED * delta * _direction)


func _on_area_entered(area):
	pass # Replace with function body.


func reverse_direction():
	_direction *= -1
