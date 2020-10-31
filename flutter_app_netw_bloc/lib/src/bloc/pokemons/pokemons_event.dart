import 'package:equatable/equatable.dart';

abstract class PokemonsEvent extends Equatable{
  const PokemonsEvent();

  @override
  List<Object> get props => [];
}

class AddMorePokemons extends PokemonsEvent{}