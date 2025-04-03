export interface DadosProgresso {
  nomeColaborador: string;
  nomeEmpresa: string;
  dadosTrilha: DadosProgressoTrilha[];
}

export interface DadosProgressoTrilha {
  dataConclusaoTrilha: string;
  validadeTrilha: number;
  nomeTrilha: string;
}
